package com.java.racecondition;

public class CriticalSectionCounter {
    public int count = 0;
    public void add(int value){
        this.count = this.count +value; // Not Atomic operation
    }
}
