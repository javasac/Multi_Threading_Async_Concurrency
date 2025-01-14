package com.dsa.Threading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicExample
{
    public static void main(String[] args)
    {
        ExecutorService ex = Executors.newFixedThreadPool(20);
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
