package com.BankAccount.wait_notify;

public class Deposit_Withdraw
{
    public static void main(String[] args)
    {
        BankAccount ba = new BankAccount();

        Thread t1 = new Thread(() -> {
            try
            {
                ba.Withdraw(1678);
            }
            catch (InterruptedException ex)
            {
                ex.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try
            {
                Thread.sleep(500);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            ba.Deposit(5200);
        });

        t1.start();
        t2.start();
    }
}
