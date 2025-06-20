package com.Sachin.Threads;

public class ThreadTest extends Thread
{
    ThreadTest(String name)
    {
        super(name);
    }

    @Override
    public void run()
    {
        for (int i=1; i<=5; i++)
        {
            System.out.println(Thread.currentThread().getName() + " Priority = " + Thread.currentThread().getPriority() + " and Count = " + i);

            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException ie)
            {
                throw new RuntimeException(ie);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException
    {
        ThreadTest t1 = new ThreadTest("Sachin");

        t1.start();
        t1.join();

        System.out.println("Hello in Main");
    }
}
