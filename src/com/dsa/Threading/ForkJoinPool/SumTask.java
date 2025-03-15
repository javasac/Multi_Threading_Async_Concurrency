package com.dsa.Threading.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

class SumTask extends RecursiveTask<Long>
{
    private final int[] array;
    private final int start;
    private final int end;

    SumTask(int[] array, int start, int end)
    {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute()
    {
        long sum = 0;

        if (end - start <= 10)
        {
            //System.out.println("When Start - End <=10.");
            for (int i=start; i<=end; i++)
            {
                sum = sum + array[i];
            }

            return sum;
        }
        else
        {
            //System.out.println("When Start - End is greater than 10.");
            int mid = (start + end) / 2;

            SumTask left = new SumTask(array, start, mid);
            SumTask right = new SumTask(array, mid, end);

            left.fork();
            right.fork();

            long leftResult = left.join();
            long rightResult = right.join();

            sum = leftResult + rightResult;
            return sum;
        }
    }
}
