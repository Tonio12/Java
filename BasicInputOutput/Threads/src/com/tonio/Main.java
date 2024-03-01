package com.tonio;

import static com.tonio.ThreadColor.ANSI_PURPLE;
import static com.tonio.ThreadColor.ANSI_RED;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello from main class");

        Thread anotherThread = new AnotherThread();
        anotherThread.start();

        new Thread(() -> System.out.println(ANSI_PURPLE + "Hello From anonymous thread")).start();

        Thread  myRunnableThread  =new Thread(new MyRunnable());
        myRunnableThread.start();
        System.out.println(ANSI_RED + "Hello again from the main thread");
    }
}
