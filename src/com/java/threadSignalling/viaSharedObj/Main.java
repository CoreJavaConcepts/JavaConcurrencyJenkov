package com.java.threadSignalling.viaSharedObj;

public class Main {

    public static void main(String[] args) {
        //Signalling using shared obj
        //Waste of resources, waiting thread keep checking

        SharedSignal signal = new SharedSignal();
        Thread tr1 = new Thread(new WaitingRunnable(signal));
        Thread tr2 = new Thread(new NotifyingRunnable(signal));

        tr1.start();
        tr2.start();

        try{
            tr1.join();
            tr2.join();
        }catch (InterruptedException ex){

        }


    }
}
