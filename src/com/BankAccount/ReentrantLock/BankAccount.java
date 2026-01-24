package com.BankAccount.ReentrantLock;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class BankAccount
{
    private int balance;
    private final ReentrantLock lock = new ReentrantLock(true); // fair lock
    private final Condition sufficientFunds = lock.newCondition();

    public BankAccount(int initBal)
    {
        this.balance = initBal;
    }

    public void deposit(int amount)
    {
        lock.lock();

        try
        {
            System.out.println(Thread.currentThread().getName() + " Depositing = " + amount);

            balance += amount;
            System.out.println("New Balance = " + balance);

            sufficientFunds.signalAll();  // Wake up waiting withdraw threads
        }
        finally
        {
            lock.unlock();
        }
    }

    public void withdraw(int amount) throws InterruptedException
    {
        lock.lock();

        try
        {
            System.out.println(Thread.currentThread().getName() + " trying to withdraw = " + amount);

            while (balance < amount)
            {
                System.out.println("Insufficient balance. Waiting...");
                sufficientFunds.await(); // releases lock + waits
            }

            balance -= amount;
            System.out.println("Withdrawal successful. Remaining balance: " + balance);
        }
        finally
        {
            lock.unlock();
        }
    }
}
