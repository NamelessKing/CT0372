package it.myImplementations.class_exercises.Breakout;

import java.util.*;

public class VirtualIterable<T> implements Iterable<T>{

    private final List[] lists;
    
    public VirtualIterable(List[] lists){
        this.lists = lists;
    }
    
    @Override
    public Iterator<T> iterator() {
        return new Iterator(){
            
            int external = 0;
            int internal = 0;

            public boolean hasNext(){
                return external < lists.length && internal < lists[external].size();
            }

            public T next() {
                if(! hasNext())
                    return null;
                T next = (T)lists[external].get(internal++);
                if(internal == lists[external].size()){
                    internal = 0;
                    external++;
                }
                return next;
            }
        };
    }

}
