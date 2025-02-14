package com.dsa.Threading;
import java.util.concurrent.*;

public class SemaphoreUse
{
    public static void main(String[] args)
    {
        Semaphore semaphore = new Semaphore(3);
        ExecutorService executorService = new ThreadPoolExecutor(5, 10, 60L, TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>());

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