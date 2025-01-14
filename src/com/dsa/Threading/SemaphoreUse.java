package com.dsa.Threading;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SemaphoreUse
{
    public static void main(String[] args)
    {
        Semaphore semaphore = new Semaphore(3);
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i = 1; i <= 10; i++)
        {
            int taskId = i;
            executorService.submit(() ->
            {
                try
                {
                    semaphore.acquire();
                    System.out.println("Task " + taskId + " is running.");
                    Thread.sleep(1000);
                    System.out.println("Task " + taskId + " is completed.");
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
                finally
                {
                    semaphore.release();
                }
            });
        }

        executorService.shutdown();
    }
}