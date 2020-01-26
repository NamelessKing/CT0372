package it.myImplementations.exams.exam_18_12_2017;

import java.util.ArrayList;

public class MagicBox<T> {


    public interface Filter{
        boolean accept(Object x);
    }


    ArrayList<T> box;

    public MagicBox() {
        box = new ArrayList<>();
    }

    public boolean add(T value){
        return box.add(value);
    }

    public boolean contains(T value){
        return box.contains(value);
    }

    public boolean remove(T value){
        return box.remove(value);
    }

    public int size(){
        return box.size();
    }

    public ArrayList<T> toArrayList(){
        return (ArrayList<T>) box.clone();
    }

    public MagicBox<T> filterWith(Filter f){
        MagicBox<T> copy = new MagicBox<>();
        for(T e : box)
            if(f.accept(e))
                copy.add(e);
        return copy;
    }

}
