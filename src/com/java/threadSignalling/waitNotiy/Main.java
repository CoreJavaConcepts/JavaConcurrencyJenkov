package com.java.threadSignalling.waitNotiy;

public class Main {
    public static void main(String[] args) {
        Message msg = new Message("process it");
        new Thread(new Waiter(msg), "waiter").start();
        new Thread(new Notifier(msg), "notifier").start();

        System.out.println("All Threads started");
    }
}
