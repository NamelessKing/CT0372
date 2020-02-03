package it.myImplementations.class_exercises.Breakout;

import java.awt.*;
import java.awt.geom.Arc2D;
import java.awt.geom.Rectangle2D;

public class Paddle implements CollidableRectangle, Drawable {
    
    private Rectangle2D.Double shape, pit;
    private GradientPaint steelGradient;
    private GradientPaint padGradient;
    
    public Paddle (Rectangle2D.Double pit, double width, double height, double paddleOffset){
        this.pit = pit;
        this.shape = new Rectangle2D.Double(pit.x+(pit.width-width)/2.0,
                                            pit.y+(pit.height-height-paddleOffset),
                                            width, height);
        steelGradient =  new GradientPaint(0, 0, new Color(0xff333333), 0, (int)(height/2), Color.white, true);    
        padGradient   =  new GradientPaint(0, 0, new Color(0xffff0000), 0, (int)(height), new Color(0xff770000), true);  
    }
        
    public Rectangle2D.Double getRectangle() {
        return shape;
    }
    
    public void setPosition(double position){        
        shape.x = Math.max(pit.x, Math.min ( pit.x+pit.width-shape.width, position - shape.width / 2.0 ));
    }         
    
    public void paint (Graphics2D g){
        Rectangle2D.Double bar = new Rectangle2D.Double(shape.x+shape.height/2.0, shape.y, shape.width-shape.height, shape.height);
        Arc2D.Double leftPad  = new Arc2D.Double(shape.x, shape.y, shape.height, shape.height, 90, 180, Arc2D.CHORD);
        Arc2D.Double rightPad = new Arc2D.Double(shape.x+shape.width-shape.height, shape.y, shape.height, shape.height, 270, 180, Arc2D.CHORD);
        g.setPaint(padGradient);
        g.fill(leftPad);
        g.fill(rightPad);
        g.setPaint(steelGradient);
        g.fill(bar);
        g.setColor(Color.black);
        g.draw(leftPad);
        g.draw(rightPad);
        g.draw(bar);        
    }
       
}