package com.dsa.Threading;

public class Virtual_Threads
{
    public static void main(String[] args)
    {
        Thread pt = Thread.ofPlatform().unstarted(() -> System.out.println(Thread.currentThread()));
        pt.start();
        Thread vt = Thread.ofVirtual().unstarted(() -> System.out.println(Thread.currentThread()));
        vt.start();

        try
        {
            pt.join();
            vt.join();
            System.out.println("Class = " + vt.getClass());
        }
        catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }
    }
}
