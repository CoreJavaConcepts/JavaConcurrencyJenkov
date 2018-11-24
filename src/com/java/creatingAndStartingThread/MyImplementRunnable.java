package com.java.creatingAndStartingThread;

public class MyImplementRunnable implements Runnable{
    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName +  " Thread from implemented Runnable");
    }
}
