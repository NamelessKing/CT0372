package it.myImplementations.book.ch10.e_10_08;

import it.myImplementations.book.ch10.common.Data;
import it.myImplementations.book.ch10.common.Measurable;
import it.myImplementations.book.ch10.e_10_01.BankAccount;

public class Main_e_10_08 {
    public static void main(String[] args) {
        Measurable[] accounts = new Measurable[3];
        accounts[0] = new BankAccount(4000);
        accounts[1] = new BankAccount(17525);
        accounts[2] = new BankAccount(19200);

        Measurable max = Data.max(accounts,
                measurable -> measurable.getMeasure()
        );

        System.out.println(max.getMeasure());
    }
}
