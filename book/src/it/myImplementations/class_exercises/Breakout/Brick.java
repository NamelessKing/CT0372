package it.myImplementations.class_exercises.Breakout;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;

public class Brick implements CollidableRectangle, Drawable{

    public enum Type { 
        red    (0xffcc0000,1), 
        green  (0xff00cc00,1),
        blue   (0xff0000cc,1),
        cyan   (0xff00cccc,1), 
        yellow (0xffcccc00,1), 
        magenta(0xffcc00cc,1), 
        white  (0xffcccccc,1),
        steel  (0xff888888,3),
        gold   (0xffff8800,1000000000);
        
        public final Color color;
        public final int hits;
        
        private Type(final int color, final int hits){
            this.color = new Color(color);
            this.hits = hits;
        }        
    }
        
    private Rectangle2D.Double shape;
    private Path2D.Double topLeft, bottomRight;
    private Color color, bright, dark;
    private int hits;
    
    
    public Brick(Rectangle2D.Double shape, Type type){
        this.shape = new Rectangle2D.Double(shape.x,shape.y,shape.width,shape.height);
        hits = type.hits;
        color = type.color;
        bright = color.brighter();
        dark = color.darker();
        double insets = shape.height / 4.0;
        topLeft = new Path2D.Double();
        topLeft.moveTo(shape.x, shape.y);
        topLeft.lineTo(shape.x+shape.width, shape.y);
        topLeft.lineTo(shape.x+shape.width-insets, shape.y+insets);
        topLeft.lineTo(shape.x+insets, shape.y+insets);
        topLeft.lineTo(shape.x+insets, shape.y+shape.height-insets);
        topLeft.lineTo(shape.x, shape.y+shape.height);
        topLeft.lineTo(shape.x, shape.y);
        bottomRight = new Path2D.Double();
        bottomRight.moveTo(shape.x+shape.width, shape.y+shape.height);
        bottomRight.lineTo(shape.x, shape.y+shape.height);
        bottomRight.lineTo(shape.x+insets, shape.y+shape.height-insets);
        bottomRight.lineTo(shape.x+shape.width-insets, shape.y+shape.height-insets);
        bottomRight.lineTo(shape.x+shape.width-insets, shape.y+insets);
        bottomRight.lineTo(shape.x+shape.width, shape.y);
        bottomRight.lineTo(shape.x+shape.width, shape.y+shape.height);
    }
    
    public Rectangle2D.Double getRectangle()
    {
        return shape;
    }
    
    public void paint (Graphics2D g){
        g.setColor(color);
        g.fill(shape);
        g.setColor(bright);
        g.fill(topLeft);
        g.setColor(dark);
        g.fill(bottomRight);
        g.setColor(Color.black);
        g.draw(shape);
    }
    
    public boolean isDestroyed(){
        return((--hits)<=0);
    }
    
}
