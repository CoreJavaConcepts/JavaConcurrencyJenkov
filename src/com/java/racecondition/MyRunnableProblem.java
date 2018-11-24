package com.java.racecondition;

public class MyRunnableProblem implements Runnable{
    private CriticalSectionCounter counter;

    public MyRunnableProblem(CriticalSectionCounter counter){
        this.counter = counter;
    }

    @Override
    public void run() {
        this.counter.add(1);
    }
}
