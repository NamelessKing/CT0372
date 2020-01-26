package it.myImplementations.exams.exam_22_01_2018;

public interface Insieme<T> {

    boolean add(T x);
    boolean remove(Object x);
    boolean contains(Object x);

    default void print(){
        System.out.println("print() non implemented");
    }

}
