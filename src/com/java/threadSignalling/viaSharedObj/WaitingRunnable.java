package com.java.threadSignalling.viaSharedObj;

public class WaitingRunnable implements Runnable {

    private SharedSignal sharedSignal;

    public WaitingRunnable(SharedSignal signal){
        this.sharedSignal = signal;
    }

    @Override
    public void run() {
        System.out.println("before waiting");

        while(!sharedSignal.hasDataToProcess()){
            //do noting...waiting
            System.out.println("waiting");
        }

        System.out.println("After waiting");

    }
}
