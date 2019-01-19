package com.java.atomicvariables;

import java.util.concurrent.atomic.AtomicBoolean;

public class MyLockCompareAndSwap {
    private boolean locked = false;


    public MyLockCompareAndSwap(boolean locked) {
        this.locked = locked;
    }

    public boolean lock() {//check if locked false and then mark locked to true and return indication that its locked
        if(!locked) {//check then act operation, not thread safe
            locked = true;
            return true;
        }
        return false;
    }

    //---------Safe

    private AtomicBoolean atomicBoolean = new AtomicBoolean(false);

    public boolean safeLock() {//Equivalent to above method but safe
        atomicBoolean.compareAndSet(false, true);
        return atomicBoolean.get();

    }
}
