package it.myImplementations.ch10.e_10_1;

import it.myImplementations.ch10.common.Measurable;

/**
 A bank account has a balance that can be changed by
 deposits and withdrawals.
 */
public class BankAccount implements Measurable, Comparable
{

    private double balance;

    /**
     Constructs a bank account with a zero balance.
     */
    public BankAccount()
    {
        balance = 0;
    }

    /**
     Constructs a bank account with a given balance.
     @param initialBalance the initial balance
     */
    public BankAccount(double initialBalance)
    {
        balance = initialBalance;
    }

    /**
     Deposits money into the bank account.
     @param amount the amount to deposit
     */
    public void deposit(double amount)
    {
        balance = balance + amount;
    }

    /**
     Withdraws money from the bank account.
     @param amount the amount to withdraw
     */
    public void withdraw(double amount)
    {
        balance = balance - amount;
    }

    /**
     Gets the current balance of the bank account.
     @return the current balance
     */
    public double getBalance()
    {
        return balance;
    }

    public double getMeasure()
    {
        return balance;
    }


    @Override
    public int compareTo(Object o) {
        return 0;
    }
}