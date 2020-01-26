package it.myImplementations.exams.exam_22_01_2018;

import java.util.ArrayList;
import java.util.Iterator;

public class InsiemiI extends ArrayList<Integer> implements Insieme<Integer>,Iterable<Integer> {

    private int limitedPositiveContainer[];
    private int limitedNegativeContainer[];

    public InsiemiI() {
        this.limitedPositiveContainer = new int[1001];
        this.limitedNegativeContainer = new int[1000];
    }

    @Override
    public boolean add(Integer x) {

        if((Integer)x >= 0 && (Integer)x <= 1000){
            if(!contains(x)) {
                limitedPositiveContainer[(Integer) x] = 1;
                return true;
            }else{
                return false;
            }
        }else
        if((Integer)x <= -1 && (Integer)x > -1000){
            if(!contains(x)) {
                limitedNegativeContainer[-((Integer) x)] = 1;
                return true;
            }else{
                return false;
            }
        }

        return false;

    }

    @Override
    public boolean remove(Object x) {

        if(x instanceof Integer) {
            if ((Integer) x >= 0 && (Integer) x <= 1000) {
                if (contains(x)) {
                    limitedPositiveContainer[(Integer) x] = 0;
                    return true;
                } else {
                    return false;
                }
            } else if ((Integer) x <= -1 && (Integer) x >= -1000) {
                if (contains(x)) {
                    limitedNegativeContainer[-((Integer) x)] = 0;
                    return true;
                } else {
                    return false;
                }
            }
        }

        return false;



    }

    @Override
    public boolean contains(Object x) {
        if(x instanceof Integer){

            if((Integer)x >= 0 && (Integer)x <= 1000){
                return limitedPositiveContainer[(Integer) x] == 1;
            }else
            if((Integer)x <= -1 && (Integer)x > -1000){
                return limitedNegativeContainer[-((Integer) x)] == 1;
            }
        }

        return false;

    }

    @Override
    public void print() {

        StringBuilder values = new StringBuilder();

        for(int i = 1000 - 1; i >= 1; i--){
            if(limitedNegativeContainer[i] == 1){
                values.append(-i).append(" ,");
            }
        }

        for(int i = 0; i <1000 ; i++){
            if(limitedPositiveContainer[i] == 1){
                values.append(i).append(" ,");
            }
        }

        System.out.println(values);
    }

    @Override
    public Iterator<Integer> iterator() {
        return null;
    }
}
