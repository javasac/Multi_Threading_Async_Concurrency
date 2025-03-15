package com.dsa.Threading;
import java.util.concurrent.*;

public class CompletableFutureExample
{
    public static void main(String[] args) throws InterruptedException, ExecutionException
    {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() ->
        {
            try
            {
                System.out.println("Task 1: Starting computation...");
                Thread.sleep(2000);  // Simulate delay
                return 10;
            }
            catch (InterruptedException e)
            {
                throw new RuntimeException(e);
            }
        });

        CompletableFuture<Integer> resultFuture = future.thenApply(result ->
        {
            System.out.println("Task 2: Received result from Task 1: " + result);
            return result * 2; // Multiply the result by 2
        });

        resultFuture.thenAccept(result ->
        {
            System.out.println("Task 3: Final result after applying transformation: " + result);
        });

        future.exceptionally(ex ->
        {
            System.out.println("Error: " + ex.getMessage());
            return 0; // Default result in case of an error
        });

        resultFuture.get();
        System.out.println("Main thread: All tasks completed.");
    }
}
