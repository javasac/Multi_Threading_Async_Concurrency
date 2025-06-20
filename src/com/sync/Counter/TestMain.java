package com.sync.Counter;

public class TestMain
{
    public static void main(String[] args)
    {
        Counter ctr = new Counter();

        ThreadCounter t1 = new ThreadCounter(ctr);
        ThreadCounter t2 = new ThreadCounter(ctr);

        t1.start();
        t2.start();

        try
        {
            t1.join();
            t2.join();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        System.out.println("Counter is " + ctr.getCount());
    }
}
