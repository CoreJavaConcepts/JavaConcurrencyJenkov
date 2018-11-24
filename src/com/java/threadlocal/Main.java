package com.java.threadlocal;

public class Main {
    public static void main(String[] args) {

        //Thread local is local variable that you dont want to share with other thread, not required synchronization as like other shared value

        MyRunnable sharedRunnable = new MyRunnable();

        Thread tr1 = new Thread(sharedRunnable, "Thread A");
        Thread tr2 = new Thread(sharedRunnable, "Thread B");
        tr1.start();
        tr2.start();

        try{
            tr1.join();
            tr2.join();
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }

    }
}
