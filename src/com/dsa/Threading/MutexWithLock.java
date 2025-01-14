package com.dsa.Threading;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class MutexWithLock
{
    private static final ReentrantLock lock = new ReentrantLock();
    private static int counter = 0;

    public static void increment()
    {
        lock.lock();

        try
        {
            counter = counter + 1;
            System.out.println("Counter is " + counter);
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

    public static void main(String[] args)
    {
        ExecutorService ex = Executors.newFixedThreadPool(25);

        for (int i = 1; i <= 10; i++)
        {
            ex.submit(() ->
            {
                increment();
            });
        }
    }
}
