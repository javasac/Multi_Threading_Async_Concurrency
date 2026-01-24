package com.BankAccount.Semaphore;
import java.util.concurrent.Semaphore;

public class BankAccount
{
    private final Semaphore balance;

    public BankAccount(int amt)
    {
        this.balance = new Semaphore(amt, true);
    }

    // Deposit money
    public void deposit(int amt)
    {
        System.out.println(Thread.currentThread().getName() + " depositing = " + amt);
        balance.release(amt); // add permits
        System.out.println("Deposit successful. Available balance: " + balance.availablePermits());
        System.out.println();
    }

    // Withdraw money
    public void withdraw(int amount) throws InterruptedException
    {
        System.out.println(Thread.currentThread().getName() + " trying to withdraw = " + amount);
        System.out.println("Insufficient Balance is " + balance.availablePermits());
        System.out.println();

        balance.acquire(amount); // blocks if insufficient permits
        System.out.println("Withdrawal successful. Remaining balance = " + balance.availablePermits());
    }
}
