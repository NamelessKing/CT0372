package it.myImplementations.class_exercises.Breakout;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;

public class Game extends JComponent{
    
    static final Rectangle2D.Double screen = new Rectangle2D.Double( 0.0,  0.0, 450.0, 600.0);
    static final Rectangle2D.Double pit    = new Rectangle2D.Double(10.0, 10.0, 430.0, 580.0);
    static final double brickOffset        = 20.0;
    static final double brickAspect        = 0.5;
    static final double brickWidth         = 50;
    static final double brickHeight        = 30;    
    static final double paddleOffset       = 30.0;
    static final double paddleHeight       = 15.0;
    static final double paddleWidth        = 80.0;
    static final double ballRadius         = 5.0;
    static final double liveRadius         = 5.0;
    static final int initBallTimer         = 5000;
    static final int initialBalls          = 1;
    static final int initialLives          = 3;
    static final int frameDelay            = 20;
    static final int timeStep              = 1;
    static final boolean randomSpeeds      = initialBalls > 1;
    static final Brick.Type[][][] levelSet = Levels.classic_set;
    static final String[] textureSet       = Levels.textures_set_1;
    
    private enum Status { gameOver, gameRunning }
    private Status status;
    
    private final ArrayList<Brick> bricks = new ArrayList<>();
    private final ArrayList<Ball> balls = new ArrayList<>(); 
    private final ArrayList<Border> borders = new ArrayList<>();
    private final ArrayList<Paddle> paddles = new ArrayList<>();
    private VirtualIterable<Drawable> drawingElements = new VirtualIterable<>( new ArrayList[]{ bricks, balls, paddles } );
    private Border bottom;
    private Paddle paddle;
    
    private int lives;
    
    private ArrayBlockingQueue<Brick.Type[][]> levels;
    private ArrayBlockingQueue<String> textures;
    private BufferedImage background;
    
    private AffineTransform screenTransform;
    private boolean antialias = true;
    private boolean useTransform = true;
    
    private long physicsTime, ballTime, frameTime;
    
    public Game() {
        
        status = Status.gameOver;        
        
        borders.add(new Border(new Rectangle2D.Double(screen.x, screen.y, pit.x-screen.x, screen.height)));
        borders.add(new Border(new Rectangle2D.Double(pit.x+pit.width, screen.y, screen.width-(pit.x+pit.width), screen.height)));
        borders.add(new Border(new Rectangle2D.Double(pit.x, screen.y, pit.width, pit.y-screen.y)));
        borders.add(bottom = new Border(new Rectangle2D.Double(pit.x, pit.y+pit.height, pit.width, screen.height-(pit.y+pit.height))));

        paddles.add(paddle = new Paddle(pit, paddleWidth, paddleHeight, paddleOffset));
        
        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                switch (status) {
                    case gameOver:
                        startGame();
                        break;
                    case gameRunning:
                        ballTime = 0;
                        break;
                }
            }
        });
        
        addMouseMotionListener(new MouseAdapter() {
            public void mouseMoved(MouseEvent e) {
                if(status==Status.gameRunning){
                    try {
                        Point2D.Double realPosition = new Point2D.Double();
                        screenTransform.inverseTransform(new Point2D.Double(e.getX(), e.getY()), realPosition);
                        paddle.setPosition(realPosition.x);
                    }catch(Exception ex){
                        paddle.setPosition(e.getX());
                    }                      
                }
            }
        });
        
        (new Thread(()->{runGame();})).start();
        
    }
    
    private AffineTransform createScreenTransform(int width, int height, double angle){
        double scale = Math.min(width / screen.width, height / screen.height);
        double xtrans = Math.max(0.0, (width - screen.width * scale) / 2.0);
        double ytrans = Math.max(0.0, (height - screen.height * scale) / 2.0);
        AffineTransform transform = new AffineTransform();
        if(angle!=0.0)
           transform.concatenate(AffineTransform.getRotateInstance(angle, width/2, height/2));           
        transform.concatenate(AffineTransform.getTranslateInstance(xtrans, ytrans));
        transform.concatenate(AffineTransform.getScaleInstance(scale, scale));   
        return transform;
    }

    @Override
    public void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D)g;
        
        GradientPaint gradient = new GradientPaint(0, 0, new Color(0xff333333), 0, getHeight(), Color.white, true);
        g2.setPaint(gradient);
        g2.fillRect(0, 0, getWidth(), getHeight());
        
        if(antialias)
           g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        if(useTransform)
           g2.transform(screenTransform = createScreenTransform(getWidth(), getHeight(), 0.0));

        switch (status) {
            case gameOver    : drawTitleScreen(g2); break;
            case gameRunning : drawGame(g2);        break;
        }
    }

    private void drawTitleScreen(Graphics2D g2) {
        g2.setColor(Color.black);
        String text = "Press Start to Begin";
        Font titleFont = new Font(Font.SANS_SERIF, Font.BOLD, 20);
        g2.setFont(titleFont);
        FontMetrics metrics = g2.getFontMetrics(titleFont);
        int hgt = metrics.getHeight();
        int adv = metrics.stringWidth(text);
        g2.drawString(text, (int) ((screen.width - adv) / 2.0), (int) ((screen.height - hgt) / 2.0));
    }
        
    private void drawGame(Graphics2D g2) {

        g2.setColor(new Color(0xffdddddd));
        g2.fill(screen);
        g2.drawImage(background, (int)pit.x, (int)pit.y, null);
        g2.setColor(Color.black);
        g2.draw(screen);
        g2.draw(pit); 

        synchronized(this){
           for (Drawable d : drawingElements)
               d.paint(g2);
        }
        
        for (int live = 0; live < lives; live++) {
            Ellipse2D.Double liveImage = new Ellipse2D.Double(pit.x + liveRadius * 2.0 + live * liveRadius * 3, 
                                                              pit.y + pit.height - paddleOffset / 2.0 - liveRadius, 
                                                              liveRadius * 2, liveRadius * 2);
            g2.setColor(Color.red);
            g2.fill(liveImage);
            g2.setColor(Color.black);
            g2.draw(liveImage);
        }                   
    }
    
    public void runGame() {

        long currentTime = physicsTime = System.currentTimeMillis();
                
        while (true) {
            
            try { Thread.sleep(frameDelay); } catch (InterruptedException ex) {}
            
            frameTime = (currentTime = System.currentTimeMillis()) - physicsTime;
            physicsTime = currentTime;
               
            if(status==Status.gameRunning)
            {                  
               for(int step=0; step<frameTime; step+=timeStep)
                  updatePhysics(timeStep);
               
               repaint();
            }
        }
    }    
    
    private void updatePhysics(int millis){

        ArrayList<Brick> destroyedBricks = new ArrayList<Brick>();
        ArrayList<Ball> lostBalls = new ArrayList<Ball>();

        for (Ball ball : balls) {

            if (physicsTime - ballTime < initBallTimer )

                ball.setPosition(new Point2D.Double(paddle.getRectangle().x+paddle.getRectangle().width/2.0, 
                                                    paddle.getRectangle().y -ball.getRadius()));                
            else
            {                    
                for(Brick brick : bricks)
                    if (ball.detectCollision(brick)){
                        if(brick.isDestroyed())
                            destroyedBricks.add(brick);
                        break;
                    }                               

                if (ball.detectCollision(paddle))
                    ball.setDirection(( ball.getPosition().x - ( paddle.getRectangle().x + paddle.getRectangle().width / 2.0 ) ) / paddle.getRectangle().width);

                for(Border border : borders)
                    if(ball.detectCollision(border) && border==bottom)
                        lostBalls.add(ball);
                        
                ball.update(millis);                
            }

        }

        synchronized (this) {
            for (Brick brick : destroyedBricks)
                bricks.remove(brick);            
            for (Ball ball : lostBalls)
                balls.remove(ball);
        }

        if (bricks.isEmpty())
            if (levels.isEmpty()) 
                status = Status.gameOver;
            else
            {
                setupNextLevel();
                resetBalls();
            }

        if (balls.isEmpty())
            if (lives-- == 0) 
                status = Status.gameOver;
            else
                resetBalls();

    }    

    private void resetBalls() {

        balls.clear();

        for (int b = 0; b < initialBalls; b++) {
            Ball newBall = new Ball(new Point2D.Double(0, 0), ballRadius);
            if (randomSpeeds)
                newBall.setSpeed(new Point2D.Double(Math.random()*0.1+0.05, -(Math.random()*0.2+0.1)));
            else
                newBall.setSpeed(new Point2D.Double(0.10, -0.20));
            balls.add(newBall);
        }

        ballTime = System.currentTimeMillis();
    }

    private void setupNextLevel()
    {
        Brick.Type[][] level = levels.poll();        

        double brickWidth = pit.width / level[0].length;
        double brickHeight = brickWidth * brickAspect;
        Rectangle2D.Double shape = new Rectangle2D.Double(pit.x, pit.y + brickOffset, brickWidth, brickHeight);

        synchronized (this) {
            bricks.clear();
            for (Brick.Type[] row : level) {
                for (Brick.Type brick : row) {
                    if (brick != null)
                        bricks.add(new Brick(shape, brick));
                    shape.x += brickWidth;
                }
                shape.x = pit.x;
                shape.y += brickHeight;
            }
        }
        
        try {
            String backgroundName = textures.poll();
            BufferedImage backgroundImage = ImageIO.read(getClass().getResourceAsStream("/breakout/resources/" + backgroundName));
            TexturePaint tp = new TexturePaint(backgroundImage, new Rectangle2D.Double(0, 0, backgroundImage.getWidth(), backgroundImage.getHeight()));
            background = new BufferedImage((int) pit.width, (int) pit.height, BufferedImage.TYPE_INT_RGB);
            Graphics2D g = background.createGraphics();
            g.setPaint(tp);
            g.fill(new Rectangle2D.Double(0,0,pit.width,pit.height));
        } catch (IOException ex) {
            System.out.println("Warning: background file missing");
        }        
    }
        
    public void startGame() {
        
        
        levels = new ArrayBlockingQueue<Brick.Type[][]>(levelSet.length);
        for (Brick.Type[][] level : levelSet)
            levels.add(level);
        
        textures = new ArrayBlockingQueue<String>(textureSet.length);
        for (String texture : textureSet)
            textures.add(texture);
        
        setupNextLevel();        
        resetBalls();
        
        lives = initialLives;
        status = Status.gameRunning;
    }

    public void stopGame() {
        status = Status.gameOver;
        repaint();
    }
    
}
