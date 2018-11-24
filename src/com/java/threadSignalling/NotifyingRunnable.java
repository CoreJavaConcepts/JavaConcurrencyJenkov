package com.java.threadSignalling;

public class NotifyingRunnable implements Runnable {

    private SharedSignal sharedSignal;

    public NotifyingRunnable(SharedSignal sharedSignal) {
        this.sharedSignal = sharedSignal;
    }

    @Override
    public void run() {
        System.out.println("before notifying");
        try{
            Thread.sleep(5);
        }catch(InterruptedException ex){

        }
        sharedSignal.setHasDataToProcess(true);
        System.out.println("After Notifying");

    }
}
