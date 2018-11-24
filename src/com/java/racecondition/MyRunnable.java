package com.java.racecondition;

public class MyRunnable implements Runnable {

    private TwoSumsSolutionRaceCondition twoSums;

    public MyRunnable(TwoSumsSolutionRaceCondition twoSums){
        this.twoSums = twoSums;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        this.twoSums.add(1,1);
        System.out.println(threadName +" "+ twoSums.sum1+" "+twoSums.sum2);
    }
}
