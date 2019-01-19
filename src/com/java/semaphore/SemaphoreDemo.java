package com.java.semaphore;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo implements Runnable {
    private Semaphore semaphore;

    public SemaphoreDemo(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {

        try{
            semaphore.acquire();

            System.out.println(Thread.currentThread().getName() +" running");
            Thread.sleep(2000);
            //Critical section

            semaphore.release();

        }catch(InterruptedException ex){
            System.out.println("Inside ex");
        }

    }
}
