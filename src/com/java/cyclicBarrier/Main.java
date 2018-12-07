package com.java.cyclicBarrier;

import java.util.concurrent.CyclicBarrier;

public class Main {
    public static void main(String[] args) {
        Runnable barrier1Action = new Runnable() {
            @Override
            public void run() {
                System.out.println("Barrier action 1");
            }
        };

        Runnable barrier2Action = new Runnable() {
            @Override
            public void run() {
                System.out.println("Barrier action 2");
            }
        };

        CyclicBarrier barrier1 = new CyclicBarrier(2, barrier1Action);
        CyclicBarrier barrier2 = new CyclicBarrier(2, barrier2Action);

        Thread thread1 = new Thread(new CyclicBarrierRunnable(barrier1, barrier2), "Thread A:");
        Thread thread2 = new Thread(new CyclicBarrierRunnable(barrier1, barrier2), "Thread B:");
        thread1.start();
        thread2.start();


    }
}
