package it.myImplementations.class_exercises.Breakout;

import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import static it.myImplementations.class_exercises.Breakout.CollidableRectangle.Collision.*;
import static java.lang.Math.abs;

public interface CollidableRectangle {

   public enum Collision { VerticalCollision, HorizontalCollision, BothCollisions, NoCollision }; 
    
   public Rectangle2D.Double getRectangle(); 
    
   public default Collision checkCollision(Ball ball) {
        
        Point2D.Double p = ball.getPosition();
        Point2D.Double s = ball.getSpeed();
        double r = ball.getRadius();
   
        Rectangle2D.Double shape = this.getRectangle();
        Collision collision = NoCollision;
        
        if ((p.y + r > shape.y) && (p.y - r < shape.y + shape.height) && 
               (
                  ( abs(p.x - shape.x ) < r && s.x > 0 ) ||
                  ( abs(p.x - (shape.x+shape.width) ) < r && s.x < 0 )
               )
           )
        collision = VerticalCollision;
        
        if ((p.x + r > shape.x) && (p.x - r < shape.x + shape.width) && 
               (
                  ( abs(p.y - shape.y ) < r && s.y > 0 ) ||
                  ( abs(p.y - (shape.y+shape.height) ) < r && s.y < 0 )
               )
           )
        collision = collision==NoCollision ? HorizontalCollision : BothCollisions;
        
        return collision;
    }
    
}

