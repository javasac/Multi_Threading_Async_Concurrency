package com.dsa.Threading.ForkJoinPool;
import java.util.concurrent.ForkJoinPool;

class ForkJoinExample
{
    int arr[] = new int[1000];

    ForkJoinExample()
    {
        for (int i=0; i<arr.length; i++)
        {
            arr[i] = 1+1;
        }
    }

    void sumArrayForkJoin()
    {
        ForkJoinPool forkJoinPool = new ForkJoinPool();

        SumTask st = new SumTask(arr, 0, arr.length-1);

        long res = forkJoinPool.invoke(st);

        System.out.println("Sum of Array is " + res);
        forkJoinPool.shutdown();
    }

    public static void main(String[] args)
    {
        ForkJoinExample fj = new ForkJoinExample();
        fj.sumArrayForkJoin();
    }
}
