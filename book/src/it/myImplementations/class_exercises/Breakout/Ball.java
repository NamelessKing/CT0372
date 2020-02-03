package it.myImplementations.class_exercises.Breakout;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;

public class Ball implements Drawable{

    private final Point2D.Double position;
    private final Point2D.Double speed;
    private final double radius;
    
    public Ball (Point2D.Double position, double radius)
    {
        this.position = new Point2D.Double();
        this.speed = new Point2D.Double();
        setPosition(position);
        this.radius = radius;
    }
    
    public Point2D.Double getPosition()
    {
        return new Point2D.Double(position.x,position.y);
    }
    
    public final void setPosition(Point2D.Double position)
    {
        this.position.setLocation(position);
    }
    
    public double getRadius()
    {
        return radius;
    }        
    
    public Point2D.Double getSpeed()
    {
       return new Point2D.Double(speed.x,speed.y);
    }
    
    public void setSpeed(Point2D.Double speed)
    {
        this.speed.setLocation(speed);
    }
    
    public void setDirection(double angle){
       double modulus = Math.sqrt(speed.x*speed.x+speed.y*speed.y);
       speed.setLocation(- modulus * Math.cos(angle+Math.PI/2.0), - modulus * Math.sin(angle+Math.PI/2.0));
    }
    
    public void update(int millis)
    {
        position.setLocation(position.x+speed.x*millis,
                             position.y+speed.y*millis);
    }
    
    @Override
    public String toString()
    {
        return "Ball{px:"+position.x+",py:"+position.y+",sx:"+speed.x+",sy:"+speed.y+",r:"+radius+"}";
    }
    
    public boolean detectCollision(CollidableRectangle object)
    {
        switch(object.checkCollision(this)){
            case HorizontalCollision: speed.setLocation(speed.x,-speed.y);
                                      return true;
            case VerticalCollision:   speed.setLocation(-speed.x,speed.y);
                                      return true;
            case BothCollisions:      speed.setLocation(-speed.x,-speed.y);
                                      return true;
        }
        return false;
    }

    public void paint(Graphics2D g) {
        Ellipse2D.Double shape = new Ellipse2D.Double(position.x-radius, position.y-radius, radius*2, radius*2);
        g.setColor(Color.white);
        g.fill(shape);
        g.setColor(Color.black);
        g.draw(shape);
    }

    
}
