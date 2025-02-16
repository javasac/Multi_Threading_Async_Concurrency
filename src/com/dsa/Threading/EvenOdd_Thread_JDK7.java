package com.dsa.Threading;

public class EvenOdd_Thread_JDK7 implements Runnable
{
    String name;
    static int count = 1;
    Object object;

    public EvenOdd_Thread_JDK7(Object object, String name)
    {
        this.object = object;
        this.name = name;
    }

    @Override
    public void run()
    {
        try
        {
            while (count <= 10)
            {
                synchronized (object)
                {
                    if ((count % 2 == 0) && (this.name == "Even"))
                    {
                        System.out.println("Thread Name = " + this.name + " and value = " + count);
                        count++;
                    }

                    if ((count % 2 != 0) && (this.name == "Odd"))
                    {
                        System.out.println("Thread Name = " + this.name + " and value = " + count);
                        count++;
                    }
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        Object lock = new Object();

        EvenOdd_Thread_JDK7 odd = new EvenOdd_Thread_JDK7(lock, "Odd");
        EvenOdd_Thread_JDK7 even = new EvenOdd_Thread_JDK7(lock, "Even");

        new Thread(odd).start();
        new Thread(even).start();
    }
}
