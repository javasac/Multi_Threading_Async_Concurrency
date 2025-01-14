package com.dsa.Threading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VolatileExample
{
    static volatile int ctr=0;

    public static void main(String[] args)
    {
        ExecutorService ex = Executors.newFixedThreadPool(20);

        for (int i=1; i<=20; i++)
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

