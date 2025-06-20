package com.Sachin.ReentrantLock;

public class MainTest
{
    public static void main(String[] args)
    {
        BankAccount ba = new BankAccount();

        Runnable task = new Runnable()
        {
            @Override
            public void run()
            {
                ba.withdraw(45);
            }
        };

        Thread t1 = new Thread(task, "Thread 1");
        Thread t2 = new Thread(task, "Thread 2");
        t1.start();
        t2.start();
    }
}
