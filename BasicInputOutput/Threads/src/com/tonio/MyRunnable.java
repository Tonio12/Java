package com.tonio;

import static com.tonio.ThreadColor.ANSI_GREEN;

public class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println(ANSI_GREEN + "Hello from Runnable");
    }
}
