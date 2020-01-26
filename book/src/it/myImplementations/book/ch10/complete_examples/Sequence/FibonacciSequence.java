package it.myImplementations.book.ch10.complete_examples.Sequence;

public class FibonacciSequence implements Sequence {

    private int currentNum;
    private int previousNum;

    public FibonacciSequence() {
        this.currentNum = 0;
        this.previousNum = 0;
    }

    @Override
    public int next() {
        int sum = currentNum + previousNum;

        if(currentNum == 1 && previousNum == 1){
            previousNum = currentNum;
            currentNum = sum;
            return 1;
        }

        if(currentNum == 0){
            currentNum = 1;
        }

        previousNum = currentNum;
        currentNum = sum;

        return sum;
    }
}
