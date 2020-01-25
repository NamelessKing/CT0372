package it.myImplementations.ch10.complete_examples.Sequence;

public class RandomSequence implements Sequence {

    @Override
    public int next() {
        return (int) ( Integer.MAX_VALUE * Math.random());
    }
}
