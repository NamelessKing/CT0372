package it.myImplementations.class_exercises.Breakout;

import java.awt.geom.Rectangle2D;

public class Border implements CollidableRectangle{
    
     private Rectangle2D.Double shape;

    public Border (Rectangle2D.Double shape)
    {
       this.shape = new Rectangle2D.Double(shape.x,shape.y,shape.width,shape.height);  
    }
    
    @Override
    public Rectangle2D.Double getRectangle() {
        return shape;
    }    

}