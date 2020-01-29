package it.myImplementations.book.ch10.e_10_06;

import it.myImplementations.book.ch10.common.LastDigitDistribution;
import it.myImplementations.book.ch10.common.Sequence;

import java.util.Arrays;

public class Main_e_10_06 {
    public static void main(String[] args) {

        LastDigitDistribution dist1 = new LastDigitDistribution();
        dist1.process(Sequence.powersOf(4), 1000);
        dist1.display();

        System.out.println();

        Integer[] squares = Sequence.powersOf(4).values(20);
        System.out.println(Arrays.toString(squares));

        System.out.println();

        LastDigitDistribution dist2 = new LastDigitDistribution();
        dist2.process(Sequence.multiplesOf(4), 1000);
        dist2.display();

        System.out.println();

        Integer[] multiples = Sequence.multiplesOf(4).values(20);
        System.out.println(Arrays.toString(multiples));

        System.out.println();

        LastDigitDistribution dist3 = new LastDigitDistribution();
        dist3.process(Sequence.randomSequence(), 10);
        dist3.display();

        System.out.println();

        Integer[] random = Sequence.randomSequence().values(10);
        System.out.println(Arrays.toString(random));


    }
}
