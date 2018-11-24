package com.java.threadSignalling.waitNotiy;

public class Waiter implements Runnable {

    private Message msg;

    public Waiter(Message msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        synchronized (msg){
            while(!msg.isSignalled()){// This solves two things 1. Protect against spurios wakeup (checking signalled again after waking up)
                // 2. Missing signal (notify already run before wait)//  http://tutorials.jenkov.com/java-concurrency/thread-signaling.html          while(!msg.isWasSignalled()){// This solves two things 1. Protect against spurios wakeup 2. Missing signal //
                try{
                    System.out.println(name+" waiting to get notified at time:"+System.currentTimeMillis());
                    msg.wait();
                }catch (InterruptedException ex){
                    ex.printStackTrace();
                }
            }

        }

        System.out.println(name+" waiter thread got notified at time:"+System.currentTimeMillis());
        //process the message now
        System.out.println(name+" processed: "+msg.getMsg());

    }
}
