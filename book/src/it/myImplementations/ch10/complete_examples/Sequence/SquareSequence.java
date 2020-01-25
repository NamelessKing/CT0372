package it.myImplementations.ch10.complete_examples.Sequence;

public class SquareSequence implements Sequence {

    private int n;

    @Override
    public int next() {
        n++;
        return n * n;
    }
}
