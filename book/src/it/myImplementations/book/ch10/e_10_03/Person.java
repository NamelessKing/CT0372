package it.myImplementations.book.ch10.e_10_03;

import it.myImplementations.book.ch10.common.Measurable;
import it.myImplementations.book.ch10.common.Named;

public class Person implements Measurable, Named {

    private String name;
    private double altezza;

    public Person(String name, double altezza) {
        this.name = name;
        this.altezza = altezza;
    }



    @Override
    public String getName() {
        return this.name;
    }


}
