package it.myImplementations.class_exercises.Vectors;

public class Vector3D extends Vector2D{
    
    private double z;
    
    public Vector3D(){
        z = 0;
    }
    
    public Vector3D(double x, double y, double z){
        super(x,y);
        this.z = z;
    }
    
    public double length(){
        return Math.sqrt(z*z+super.length()*super.length());
    }
    
    public void scale(double s){
        z *= s;
        super.scale(s);
    }
    
    public void add(Vector3D other){
        z += other.z;
        super.add(other);
    }
    
    public String toString(){
        return super.toString()+","+z;
    }
    
}
