package com.java.countDownLatch;

import java.util.concurrent.CountDownLatch;

public class Decrementer implements Runnable{
    private CountDownLatch countDownLatch;

    public Decrementer(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            this.countDownLatch.countDown();
            System.out.println("After first decrement");
            Thread.sleep(1000);
            this.countDownLatch.countDown();
            System.out.println("After second decrement");
            Thread.sleep(1000);
            this.countDownLatch.countDown();
            System.out.println("After third decrement");

        }catch (InterruptedException ex){

        }

    }
}
