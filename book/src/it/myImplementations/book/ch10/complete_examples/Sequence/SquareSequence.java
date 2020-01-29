package it.myImplementations.book.ch10.complete_examples.Sequence;

import it.myImplementations.book.ch10.common.Sequence;

public class SquareSequence implements Sequence {

    private int n;

    @Override
    public int next() {
        n++;
        return n * n;
    }
}
