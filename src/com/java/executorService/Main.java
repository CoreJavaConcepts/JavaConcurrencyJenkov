package com.java.executorService;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        //http://tutorials.jenkov.com/java-util-concurrent/executorservice.html
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        //ExecutorService executorService1 = Executors.newSingleThreadExecutor();
        //ExecutorService executorService2 = Executors.newFixedThreadPool(10);
        //ExecutorService executorService3 = Executors.newScheduledThreadPool(10);

        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Runnable 1 running");
            }
        };

        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Runnable 2 running");
            }
        };

        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("Callable running");
                return "Callable Return";
            }
        };

        executorService.execute(runnable1);
        executorService.execute(runnable2);
        Future<String> future = executorService.submit(callable);
        try{
            System.out.println(future.get());
        }catch (Exception ex){
            ex.printStackTrace();
        }

        executorService.shutdown();


    }
}
