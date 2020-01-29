package it.myImplementations.book.ch10.complete_examples.Sequence;

import it.myImplementations.book.ch10.common.Sequence;

public class RandomSequence implements Sequence {

    @Override
    public int next() {
        return (int) ( Integer.MAX_VALUE * Math.random());
    }
}
