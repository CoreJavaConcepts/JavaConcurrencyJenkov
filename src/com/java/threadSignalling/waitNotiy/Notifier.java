package com.java.threadSignalling.waitNotiy;

public class Notifier implements Runnable {

    private Message msg;

    public Notifier(Message msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name + " started");

        synchronized (msg){
            try{
                Thread.sleep(1000);
                msg.setMsg(name + " Notifier work done");
                msg.setSignalled(true);
            }catch (InterruptedException ex){
                ex.printStackTrace();
            }
        }


        try{
            Thread.sleep(1000);
            synchronized (msg){
                msg.setMsg(name + " Notifier work done");
                msg.notify();
            }

        }catch (InterruptedException ex){

        }

    }
}
