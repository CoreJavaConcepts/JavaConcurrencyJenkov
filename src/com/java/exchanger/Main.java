package com.java.exchanger;

import java.util.concurrent.Exchanger;

public class Main {
    public static void main(String[] args) {
        Exchanger exchanger = new Exchanger();
        new Thread(new ExchangerRunnable("A", exchanger)).start();
        new Thread(new ExchangerRunnable("B", exchanger)).start();
    }
}
