package com.ExecutorService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadTask
{
    public static void main(String[] args)
    {
        int cores = Runtime.getRuntime().availableProcessors();
        System.out.println("# of Cores = " + cores);

        // uses Blocking Queue for Thread Safety
        //ExecutorService es = Executors.newFixedThreadPool(cores);
        ExecutorService es =  Executors.newSingleThreadExecutor();

        for (int i=1; i<=8; i++)
        {
            es.execute(new Task());
            //Thread th = new Thread(new Task());
            //th.start();
        }

        System.out.println("Thread Name = " + Thread.currentThread().getName());
        es.shutdown();
    }
}
