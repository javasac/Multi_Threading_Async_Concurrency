package com.dsa.Threading;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class CreateFiles implements Runnable
{
    int num=0;

    CreateFiles(int num)
    {
        this.num = num;
    }

    @Override
    public void run()
    {
        String fileName = "File" + this.num + ".txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName)))
        {
            for (int i = 1; i <= 999; i++)
            {
                writer.write(i + ", ");
            }
            System.out.println("File " + fileName + " created successfully by " + Thread.currentThread().getName());
        }
        catch (IOException e)
        {
            System.err.println("Error writing to file " + fileName + " : " + e.getMessage());
        }
    }

    public static void main(String[] args)
    {
        for (int i=1; i<=5; i++)
        {
            Thread th = new Thread(new CreateFiles(i));
            th.start();
        }
    }
}
