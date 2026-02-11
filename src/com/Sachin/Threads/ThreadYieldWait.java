package com.Sachin.Threads;

public class ThreadYieldWait extends Thread
{
    private static final Object lock = new Object();

    ThreadYieldWait(String name)
    {
        super(name);
    }

    @Override
    public void run()
    {
        synchronized (this)
        {
            for (int i=1; i<=10; i++)
            {
                System.out.println(Thread.currentThread().getName() + " Priority = " +
                        Thread.currentThread().getPriority() + " and Count = " + i);

                //Thread.yield();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException
    {
        ThreadYieldWait t1 = new ThreadYieldWait("Sachin");
        ThreadYieldWait t2 = new ThreadYieldWait("Kansal");

        t1.start();
        t2.start();
    }
}
