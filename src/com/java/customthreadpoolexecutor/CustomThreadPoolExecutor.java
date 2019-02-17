package com.java.customthreadpoolexecutor;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class CustomThreadPoolExecutor {
    private final BlockingQueue<Runnable> workerQueue;
    private final Thread[] workerThreads;

    public CustomThreadPoolExecutor(int numThreads){
        workerQueue = new LinkedBlockingQueue<>();
        workerThreads = new Thread[numThreads];
        int i=0;
        for(Thread t : workerThreads){
            t = new Worker("Custom pool thread "+ ++i);
            t.start();
        }

    }

    public void addTask(Runnable r) {
        try {
            workerQueue.put(r);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    class Worker extends Thread{
        public Worker(String name){
            super(name);
        }
        @Override
        public void run() {
            super.run();

            while(true){
                try{
                    System.out.println("running "+ Thread.currentThread().getName());
                    workerQueue.take().run();
                }catch (InterruptedException ex){
                    ex.printStackTrace();
                }catch (RuntimeException ex){
                    ex.printStackTrace();
                }

            }
        }
    }
}
