package com.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledES
{
    public static void main(String[] args)
    {
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(10);

        // task run after 10 seconds delay
        ses.schedule(new Task(), 10, TimeUnit.SECONDS);

        // task to run repeatedly after every 10 seconds
        ses.scheduleAtFixedRate(new Task(), 15,10, TimeUnit.SECONDS);

        // task to run repeatedly 10 seconds after previous task completes
        ses.scheduleWithFixedDelay(new Task(), 15,10, TimeUnit.SECONDS);

        ses.shutdown();
    }
}
