package com.sync.Counter;

public class ThreadCounter extends Thread
{
    private Counter ctr;

    public ThreadCounter(Counter count)
    {
        this.ctr = count;
    }

    @Override
    public void run()
    {
        for (int i=1; i<=1000; i++)
        {
            ctr.increment();
        }
    }
}
