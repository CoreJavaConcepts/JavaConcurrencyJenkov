package com.java.semaphore;

import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);
        SemaphoreDemo semaphoreDemo = new SemaphoreDemo(semaphore);
        new Thread(semaphoreDemo, "Thread 1").start();
        new Thread(semaphoreDemo, "Thread 2").start();


    }
}
