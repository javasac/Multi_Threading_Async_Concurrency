package com.BankAccount.ReentrantLock;

public class BankDemo
{
    public static void main(String[] args)
    {
        BankAccount ba = new BankAccount(500);

        Thread dep = new Thread(() -> {
            try
            {
                Thread.sleep(1000);
                ba.deposit(1200);
            }
            catch (InterruptedException it)
            {
                it.printStackTrace();
            }
        }, "Deposit-Thread");


        Thread wid = new Thread(() -> {
            try
            {
                ba.withdraw(1500);
            }
            catch (InterruptedException it)
            {
                it.printStackTrace();
            }
        }, "Withdraw-Thread");

        dep.start();
        wid.start();
    }
}
