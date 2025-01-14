package com.dsa.Threading;

class ThreadExample extends Thread
{
    private int start;
    private int limit;
    private String taskName;

    public ThreadExample(int start, int limit, String taskName)
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
            System.out.println(taskName + " Thread: " + i);

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
        ThreadExample oddThread = new ThreadExample(1, 10, "Odd");
        ThreadExample evenThread = new ThreadExample(2, 10, "Even");

        oddThread.start();
        evenThread.start();
    }
}
