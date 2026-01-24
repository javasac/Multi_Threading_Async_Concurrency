package com.BankAccount.BlockingQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BankAccount
{
    private final BlockingQueue<Integer> balanceQueue =
            new LinkedBlockingQueue<>();

    // Withdraw
    synchronized void Withdraw(int amt) throws InterruptedException
    {
        System.out.println(Thread.currentThread().getName() + " wants to withdraw " + amt);
        balanceQueue.take();
    }

    // Deposit
    synchronized void Deposit(int amt) throws InterruptedException
    {
        System.out.println(Thread.currentThread().getName() + " wants to deposit " + amt);
        balanceQueue.put(amt);
    }
}
