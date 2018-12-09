package com.java.exchanger;

import java.util.concurrent.Exchanger;

public class ExchangerRunnable implements Runnable {
    private String exchangeVal;
    private Exchanger exchanger;

    public ExchangerRunnable(String exchangeVal, Exchanger exchanger) {
        this.exchangeVal = exchangeVal;
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        try{
            String oldVal = this.exchangeVal;
            exchangeVal = (String)exchanger.exchange(this.exchangeVal);

            System.out.println(
                    Thread.currentThread().getName() +
                            " exchanged " + oldVal + " for " + this.exchangeVal
            );
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }

    }
}
