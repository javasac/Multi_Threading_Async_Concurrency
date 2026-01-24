package com.Thread_Runnable;

class TestThread implements Runnable
{
    public void run()
    {
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args)
    {
        TestThread tt = new TestThread();
        tt.run();
    }
}
