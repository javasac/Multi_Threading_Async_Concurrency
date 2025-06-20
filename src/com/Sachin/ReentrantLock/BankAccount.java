package com.Sachin.ReentrantLock;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount
{
    private int balance = 100;
    private final Lock lock = new ReentrantLock();

    public void withdraw(int amount)
    {
        System.out.println(Thread.currentThread().getName() + " attempting to withdraw " + amount);

        if (balance >= amount)
        {
            try
            {
                if (lock.tryLock(2000, TimeUnit.MILLISECONDS))
                {
                    System.out.println(Thread.currentThread().getName() + " proceeding with withdrawal of " + amount);
                    Thread.sleep(10000);
                    balance = balance - amount;
                    System.out.println(Thread.currentThread().getName() + " completed withdrawal. Remaining Balance = " + balance);
                }
                else
                {
                    System.out.println(Thread.currentThread().getName() + " could not acquire the lock, will try later.");
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            finally
            {
                lock.unlock();
            }
        }
        else
        {
            System.out.println(Thread.currentThread().getName() + " insufficient balance.");
        }
    }
}
