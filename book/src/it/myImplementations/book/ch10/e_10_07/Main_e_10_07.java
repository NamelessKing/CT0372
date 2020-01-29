package it.myImplementations.book.ch10.e_10_07;

import it.myImplementations.book.ch10.common.Sequence;

public class Main_e_10_07 {

    public static void main(String[] args) {
        Sequence squares = Sequence.powersOf(3);
        squares.process(1000);


        System.out.println();

        Sequence multiples = Sequence.multiplesOf(2);
        multiples.process(1000);


        System.out.println();

        Sequence randoms = Sequence.randomSequence();
        randoms.process( 1000);

    }
}
