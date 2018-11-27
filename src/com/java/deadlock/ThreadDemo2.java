package com.java.deadlock;

public class ThreadDemo2 extends Thread {
    private Object lock1;
    private Object lock2;

    public ThreadDemo2(Object lock1, Object lock2){
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {
        synchronized (lock2) {
            System.out.println("Thread 2: Holding lock 2...");

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {}
            System.out.println("Thread 2: Waiting for lock 1...");

            synchronized (lock1) {
                System.out.println("Thread 2: Holding lock 1 & 2...");
            }
        }
    }
}
