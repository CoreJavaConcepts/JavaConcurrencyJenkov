package com.java.racecondition;

public class Main {
    public static void main(String[] args) {
        //Problem race condition
        CriticalSectionCounter couter = new CriticalSectionCounter();
        Thread thread1 = new Thread(new MyRunnableProblem(couter));
        Thread thread2 = new Thread(new MyRunnableProblem(couter));
        thread1.start();
        thread2.start();
        try {
            Thread.sleep(1000);
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }
        System.out.println(couter.count);

        //Race condition solution
        TwoSumsSolutionRaceCondition twoSums = new TwoSumsSolutionRaceCondition();
        MyRunnable myRunnable = new MyRunnable(twoSums);
        Thread th1 = new Thread(myRunnable, "Thread A" );
        Thread th2 = new Thread(myRunnable, "Thread B" );
        th1.start();
        th2.start();

    }
}
