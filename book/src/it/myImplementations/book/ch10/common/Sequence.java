package it.myImplementations.book.ch10.common;

import java.util.ArrayList;
import java.util.Arrays;

public interface Sequence {
    int next();

    static Sequence powersOf(int n){
        return new Sequence() {

            private int base;

            @Override
            public int next() {
                base++;
                return (int) Math.pow(base,n);
            }
        };
    }

    static Sequence multiplesOf(int n){
        return new Sequence() {

            private int num;

            @Override
            public int next() {
                num++;
                return num * n;
            }
        };
    }

    static Sequence randomSequence()
    {
        return () -> (int) (Integer.MAX_VALUE * Math.random());
    }

    default Integer[] values(int n){

        ArrayList<Integer> values = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            values.add(this.next());
        }

        Integer[] integers = new Integer[values.size()];
        integers = values.toArray(integers);

        return integers;
    }

    default void process(int valuesToProcess)
    {
        int[] counters = new int[10];
        for (int i = 1; i <= valuesToProcess; i++)
        {
            int value = next();
            int lastDigit = value % 10;

            counters[lastDigit]++;
        }

        System.out.println(Arrays.toString(counters));

    }

}
