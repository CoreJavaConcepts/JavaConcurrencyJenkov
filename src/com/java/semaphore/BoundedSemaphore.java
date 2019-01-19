package com.java.semaphore;

public class BoundedSemaphore {
    private int signals = 0;
    private int bound = 0;

    public BoundedSemaphore(int upperbound) {
        this.bound = upperbound;
    }

    public synchronized void take() throws InterruptedException{
        //keep blocking untill signal is upperbound
        while(signals == bound){
            wait();
        }
        this.signals++;
        this.notify();
    }

    public synchronized void release() throws InterruptedException{
        while(signals == 0) wait(); //Block untill signal is ++, ie no take is called
        this.signals--;
        this.notify();
    }
}
