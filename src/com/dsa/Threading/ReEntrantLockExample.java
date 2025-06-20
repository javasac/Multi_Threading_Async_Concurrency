package com.dsa.Threading;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReEntrantLockExample
{
    private final Lock lock = new ReentrantLock();
    private int counter = 0;

    public void increment()
    {
        lock.lock();
        try
        {
            counter = counter + 1;
            System.out.println("Counter is " + counter);
        }
        finally
        {
            lock.unlock();
        }
    }

    public static void main(String[] args)
    {
        ReEntrantLockExample example = new ReEntrantLockExample();

        Thread t1 = new Thread(example::increment);
        Thread t2 = new Thread(example::increment);
        Thread t3 = new Thread(example::increment);

        t1.start();
        t2.start();
        t3.start();

        try
        {
            t1.join();
            t2.join();
            t3.join();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
