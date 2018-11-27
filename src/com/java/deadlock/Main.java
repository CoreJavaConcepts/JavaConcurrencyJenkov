package com.java.deadlock;

public class Main {
    public static void main(String[] args) {
        Object lock1 = new Object();
        Object lock2 = new Object();

        ThreadDemo1 t1 = new ThreadDemo1(lock1, lock2);
        ThreadDemo2 t2 = new ThreadDemo2(lock1, lock2);

        t1.start();
        t2.start();
    }
}
