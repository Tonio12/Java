package com.tonio;

import java.util.concurrent.locks.ReentrantLock;

class BankAccount {

    private double balance;
    private final String accountNumber;
    private ReentrantLock lock;

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        lock.lock();
        try {
            balance += amount;
        }finally {
            lock.unlock();
        }


    }

    public void withdraw(double amount) {
        lock.lock();
        try {
            balance -= amount;
        }finally {
            balance -= amount;
        }

    }
    public String getAccountNumber() {
        return accountNumber;
    }
    public void  printAccountNumber(){
        System.out.println("Account Number: " + accountNumber);
    }
}
