package com.java.creatingAndStartingThread;

public class Main {
    public static void main(String[] args) {
        //--- constructor takes runnable and name for follown


        //------Extend Thread
        MyThreadExtended threadA = new MyThreadExtended("Thread A");
        threadA.start();

        //-------Implement Runnable
        Thread threadB = new Thread(new MyImplementRunnable(), "Thread B");
        threadB.start();

        //------Anonumous Runnable
        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+ " Anonumous runner impl thread");
            }
        }, "Thread C");

        threadC.start();

        //------Lambda
        Thread threadD = new Thread ( () -> System.out.println(Thread.currentThread().getName() + " Lambda Thread Impl"), "Thread D");
        threadD.start();
    }
}
