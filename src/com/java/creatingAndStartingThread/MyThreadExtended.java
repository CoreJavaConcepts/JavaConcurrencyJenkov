package com.java.creatingAndStartingThread;

public class MyThreadExtended extends Thread {

    String threadName;

    public MyThreadExtended(String threadName){
        this.threadName = threadName;
    }

    @Override
    public void run(){
        Thread.currentThread().setName(threadName);
        System.out.println(Thread.currentThread().getName()+" Extended Thread");
    }
}
