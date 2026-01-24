package com.BankAccount.Semaphore;

public class BankDemo
{
    public static void main(String[] args)
    {
        BankAccount account = new BankAccount(777);

        // Withdraw thread
        Thread withdrawThread = new Thread(() -> {
            try
            {
                account.withdraw(1000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }, "Withdraw-Thread");

        // Deposit thread
        Thread depositThread = new Thread(() -> {
            try
            {
                Thread.sleep(2000); // simulate delay
                account.deposit(1500);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }, "Deposit-Thread");

        withdrawThread.start();
        depositThread.start();
    }
}
