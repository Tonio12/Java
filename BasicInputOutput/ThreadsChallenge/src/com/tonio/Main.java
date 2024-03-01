package com.tonio;

public class Main {
    public static void main(String[] args) {
        BankAccount jointAccount = new BankAccount("110",1000);

        Thread thread1 = new Thread(){
            @Override
            public void run() {
                jointAccount.deposit(300);
                jointAccount.withdraw(50);
            }
        };
        Thread thread2 = new Thread(){
            @Override
            public void run() {
                jointAccount.deposit(203.75);
                jointAccount.withdraw(100);
            }
        };

        thread1.start();
        thread2.start();
    }
}
