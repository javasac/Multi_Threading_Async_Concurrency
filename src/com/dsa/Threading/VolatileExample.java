package com.dsa.Threading;
import java.util.concurrent.*;

public class VolatileExample
{
    static volatile int ctr=0;

    public static void main(String[] args)
    {
        ExecutorService ex = new ThreadPoolExecutor(3, 5, 60L, TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>());

        for (int i=1; i<=10; i++)
        {
            ex.submit(() ->
            {
                ctr++;
                System.out.println("Thread = " + Thread.currentThread().getName() + " incremented counter to " + ctr);
            });
        }
        ex.shutdown();
    }
}

