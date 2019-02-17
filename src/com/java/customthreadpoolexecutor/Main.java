package com.java.customthreadpoolexecutor;

public class Main {
    public static void main(String[] args) {
        CustomThreadPoolExecutor threadPoolExecutor = new CustomThreadPoolExecutor(10);
        threadPoolExecutor.addTask(() -> System.out.println("First print task"));
        threadPoolExecutor.addTask(() -> System.out.println("Second print task"));
        threadPoolExecutor.addTask(() -> System.out.println("Third print task"));
    }
}
