package it.myImplementations.class_exercises.Vectors;

public class Vector2D {
    
    private double x,y;
    
    public Vector2D(){
        x = 0;
        y = 0;
    }
    
    public Vector2D (double x, double y){
        this.x = x;
        this.y = y;
    }
    
    public Vector2D (PolarCoords coords){
        x = Math.cos(coords.getTheta())*coords.getLen();
        y = Math.sin(coords.getTheta())*coords.getLen();
    }
    
    public double length(){
        return Math.sqrt(x*x+y*y);
    }
    
    public void add(Vector2D other){
        this.x += other.x;
        this.y += other.y;
    }
    
    public void scale(double s){
        this.x *= s;
        this.y *= s;
    }
    
    @Override
    public String toString(){
        return "Vector: "+x+","+y;
    }
}
