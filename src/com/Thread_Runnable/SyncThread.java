package com.Thread_Runnable;

class SyncThread extends Thread
{
    @Override
    public void run()
    {
        for (int i=1; i<=5; i++)
        {
            try
            {
                Thread.sleep(500);
            }
            catch (InterruptedException e)
            {
                throw new RuntimeException(e);
            }
            System.out.println("Thread = " + this.getName() + ", Iteration = " + i);
        }
    }

    public static void main(String[] args) throws InterruptedException
    {
        SyncThread a = new SyncThread();
        a.setName("A");
        a.run();
        a.join();

        System.out.println();
        SyncThread b = new SyncThread();
        b.setName("B");
        b.run();
        b.join();

        System.out.println();
        SyncThread c = new SyncThread();
        c.setName("C");
        c.run();
        c.join();
    }
}
