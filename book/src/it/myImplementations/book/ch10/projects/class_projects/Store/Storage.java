package it.myImplementations.book.ch10.projects.class_projects.Store;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Iterator;

public class Storage<Item> implements Iterable<Item>{

    ArrayList<Item> itemArrayList = new ArrayList<>();


    public Storage() {
    }

    public Storage(Item item) {

    }

    public boolean add(Item item){
        if(!itemArrayList.contains(item)){
            return itemArrayList.add(item);
        }else
            return false;
    }

    public boolean remove(Item item){
        return itemArrayList.remove(item);
    }



    public String printConditionaly(Condition condition){

        StringBuilder itemsWithCondition = new StringBuilder();

        for (Item i: this) {
            if (condition.predicate(i))
                itemsWithCondition.append(i.toString());
        }

        return itemsWithCondition.toString();
    }

    public void performActions(Condition condition,Action action){
        for (Item i: this) {
            if (condition.predicate(i))
                action.action(i);
        }

    }

    @NotNull
    @Override
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {

            Iterator iterator = itemArrayList.iterator();

            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public Item next() {
                return (Item) iterator.next();
            }
        };
    }


    @Override
    public String toString() {
        return itemArrayList.toString();
    }




    //interfaces utilities
    public interface Condition {
        boolean predicate(Object o);
    }

    public interface Action{
        void action(Object o);
    }
}
