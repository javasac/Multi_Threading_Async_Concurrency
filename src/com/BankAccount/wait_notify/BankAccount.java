package com.BankAccount.wait_notify;

public class BankAccount
{
    private int AccountNo;
    private String Name;
    private int Balance = 700;

    // Withdraw
    synchronized void Withdraw(int amt) throws InterruptedException
    {
        System.out.println(Thread.currentThread().getName() + " wants to withdraw " + amt);

        while (amt > Balance)
        {
            System.out.println("Insufficient Balance, waiting.....");
            System.out.println();
            wait(); // releases lock and waits
        }

        Balance = Balance - amt;
        System.out.println("Withdrawal successful. Remaining balance: " + Balance);
    }

    // Deposit
    synchronized void Deposit(int amt)
    {
        System.out.println(Thread.currentThread().getName() + " wants to deposit " + amt);
        Balance = Balance + amt;

        System.out.println("Deposit successful. New balance = " + Balance);
        notify();
    }
}
