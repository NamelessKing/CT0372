package it.myImplementations.exams.exam_18_12_2017;

import java.util.ArrayList;

public class  MagicBox2<T> extends ArrayList<T> {

    public interface Filter{
        boolean accept(Object x);

    }

    public MagicBox2<T> filterWith(Filter f){
        MagicBox2<T> copy = (MagicBox2<T>)this.clone();
        copy.removeIf( (x)-> !f.accept(x));
        return copy;
    }

    public ArrayList<T> toArrayList(){
        return (ArrayList<T>) this.clone();
    }
}
