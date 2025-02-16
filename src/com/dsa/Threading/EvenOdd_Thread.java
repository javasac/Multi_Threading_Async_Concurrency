package com.dsa.Threading;

// output is uneven
class EvenOdd_Thread implements Runnable
{
    private int start;
    private int limit;
    private String taskName;

    public EvenOdd_Thread(int start, int limit, String taskName)
    {
        this.start = start;
        this.limit = limit;
        this.taskName = taskName;
    }

    @Override
    public void run()
    {
        for (int i = start; i <= limit; i += 2)
        {
            System.out.println(taskName + " Thread: " + i + " = " + Thread.currentThread().getName());

            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {
                System.out.println(taskName + " Thread interrupted.");
            }
        }
    }

    public static void main(String[] args)
    {
        Thread oddThread = new Thread(new EvenOdd_Thread(1, 10, "Odd"));
        Thread evenThread = new Thread(new EvenOdd_Thread(2, 10, "Even"));

        oddThread.start();
        evenThread.start();
    }
}