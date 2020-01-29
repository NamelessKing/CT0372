package it.myImplementations.book.ch10.e_10_05;

import it.myImplementations.book.ch10.common.LastDigitDistribution;
import it.myImplementations.book.ch10.common.Sequence;

public class Main_e_10_5 {

    public static void main(String[] args) {

        LastDigitDistribution dist1 = new LastDigitDistribution();
        dist1.process(Sequence.powersOf(2), 1000);
        dist1.display();

        System.out.println();

        LastDigitDistribution dist2 = new LastDigitDistribution();
        dist2.process(Sequence.multiplesOf(7), 1000);
        dist2.display();
    }
}
