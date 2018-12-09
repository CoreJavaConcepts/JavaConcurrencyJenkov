package com.java.atomicvariables;

import java.util.concurrent.atomic.*;

public class Main {
    public static void main(String[] args) {
        //----------AtomicBoolean
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        atomicBoolean.set(true);
        boolean value = atomicBoolean.get();
        boolean oldValue = atomicBoolean.getAndSet(false);
        System.out.println("oldValue:"+oldValue+" newValue:"+atomicBoolean.get());

        boolean expectedValue = true;
        boolean newValue      = false;

        boolean wasNewValueSet = atomicBoolean.compareAndSet(
                expectedValue, newValue);

        //-----------AtomicInteger//AtomicLong//AtomicReference//AtomicIntegerArray//AtomicLongArray//AtomicReferenceArray
        AtomicInteger atomicInteger = new AtomicInteger(10);
        AtomicLong atomicLong = new AtomicLong(10);
        AtomicReference<String> atomicReference = new AtomicReference<>("initial val");
        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(10);
        int[] arr = new int[10];
        AtomicIntegerArray atomicIntegerArray2 = new AtomicIntegerArray(arr);
        AtomicReferenceArray<String> atomicReferenceArray = new AtomicReferenceArray<>(10);

        int i = atomicInteger.get();
        atomicInteger.set(20);

        atomicInteger.getAndAdd(10);
        atomicInteger.addAndGet(10);

        atomicInteger.incrementAndGet();
        atomicInteger.getAndIncrement();

        atomicInteger.decrementAndGet();
        atomicInteger.getAndDecrement();


    }
}
