package com.dsa.Threading;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class EvenOdd_ExecutorService_CF_JDK8
{
    public static void main(String[] args)
    {
        ExecutorService es = Executors.newFixedThreadPool(2);

        IntStream.rangeClosed(1, 10)
                .forEach(num -> {
                    CompletableFuture<Integer> oddCF = CompletableFuture.completedFuture(num)
                            .thenApplyAsync(x -> {
                                if (x % 2 != 0)
                                {
                                    System.out.println("Thread Name = " + Thread.currentThread().getName() + " value = " + x);
                                }
                                return num;
                            }, es);
                    oddCF.join();
                });

        IntStream.rangeClosed(1, 10)
                .forEach(num -> {
                    CompletableFuture<Integer> evenCF = CompletableFuture.completedFuture(num)
                            .thenApplyAsync(x -> {
                                if (x % 2 == 0) {
                                    System.out.println("Thread Name = " + Thread.currentThread().getName() + " value = " + x);
                                }
                                return num;
                            }, es);
                    evenCF.join();
                });

        es.shutdown();
    }
}
