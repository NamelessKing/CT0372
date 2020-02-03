package it.myImplementations.class_exercises.Vectors;

public abstract class Main {

    public static void main(String[] args){
        
        var list = new Vector2D[4];
        list[0] = new Vector2D(2,2);
        list[1] = new Vector3D(2,2,2);
        list[2] = new Vector2D(1,1);
        list[3] = new Vector3D(3,4,5);
        
        double totalLen=0;
        for(Vector2D v : list){
            totalLen += v.length();
            System.out.println(v.toString());
        }
        
        System.out.println(totalLen);
        
    }
    
}
