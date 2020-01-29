package it.myImplementations.book.ch10.common;

public class LastDigitDistribution {

    private int[] counters;


    public LastDigitDistribution() {
        this.counters = new int[10];
    }

    public void process(Sequence seq, int valuesToProcess)
    {
        for (int i = 1; i <= valuesToProcess; i++)
        {
            int value = seq.next();
            int lastDigit = value % 10;
            counters[lastDigit]++;
        }
    }



    public void display()
    {
        for (int i = 0; i < counters.length; i++)
        {
            System.out.println(i + ": " + counters[i]);
        }
    }
}
