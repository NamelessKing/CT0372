package it.myImplementations.book.ch10.e_10_01;

import it.myImplementations.book.ch10.common.Data;
import it.myImplementations.book.ch10.common.Measurable;

public class Main_e_10_1 {

    public static void main(String[] args) {

        Measurable[] accounts = new Measurable[3];
        accounts[0] = new BankAccount(4000);
        accounts[1] = new BankAccount(17525);
        accounts[2] = new BankAccount(19200);

        double averageBalance = Data.average(accounts);
        System.out.println("Average balance: " + averageBalance);
        System.out.println("Expected: 13575");

        double largestBalance = Data.max(accounts).getMeasure();
        System.out.println("Largest Balance: " + largestBalance);
        System.out.println("Expected: 19200");

    }
}
