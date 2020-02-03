package it.myImplementations.class_exercises.Comparisons;

import java.util.Comparator;

public class UserNameComparator implements Comparator<User>{

    private int callCounter = 0;
    
    public int getCounter(){
        return callCounter;
    }
    
    public void resetCounter(){
        callCounter = 0;
    }
    
    @Override
    public int compare(User u1, User u2) {
        callCounter++;
        return u1.getUserName().compareToIgnoreCase(u2.getUserName());
    }
    
}
