package com.dsa.Threading;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicExample
{
    public static void main(String[] args)
    {
        ExecutorService ex = new ThreadPoolExecutor(5, 10, 60L, TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>());
        AtomicInteger at = new AtomicInteger(0);

        for (int i=1; i<=10; i++)
        {
            ex.submit(() ->
            {
                int ctr = at.incrementAndGet();
                System.out.println("Thread = " + Thread.currentThread().getName() + " incremented counter to " + ctr);
            });
        }
        ex.shutdown();
    }
}
