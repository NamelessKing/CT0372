package it.myImplementations.class_exercises.Collections;

import javax.swing.JFrame;

public class Main {

    public static void main(String[] args){
        Collection<String> c = new Collection<>();
        Collection<JFrame> frames = new Collection<>();
        c.add("Test");
        c.add("Pippo");
        frames.add(new JFrame("Pippo"));
        int pos = c.elementAt(0).indexOf("st");
        System.out.println(pos);
        
    }
    
}
