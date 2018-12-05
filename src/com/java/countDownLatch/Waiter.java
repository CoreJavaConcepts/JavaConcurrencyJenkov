package com.java.countDownLatch;

import java.util.concurrent.CountDownLatch;

public class Waiter implements Runnable{
    private CountDownLatch countDownLatch;

    public Waiter(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        System.out.println("Waiter waiting");
        try{
            countDownLatch.await();
        }catch (InterruptedException ex){
            System.out.println("interrupted");
        }

        System.out.println("After await finished");
    }
}
