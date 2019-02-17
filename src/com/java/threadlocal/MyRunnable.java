package com.java.threadlocal;

public class MyRunnable implements Runnable{
    private static ThreadLocal<String> tl;

    public MyRunnable(){
        //Thread local with initial value
        this.tl =  new ThreadLocal<String>(){
            @Override
            protected String initialValue() {
                return "This is the initial value";
            }
        };
    }

    @Override
    public void run() {
        System.out.println(tl.get());
        this.tl.set(Thread.currentThread().getName()+" Thread local");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }

        System.out.println(tl.get());
    }
}
