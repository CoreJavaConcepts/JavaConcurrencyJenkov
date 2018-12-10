package com.java.atomicvariables;

import java.util.concurrent.atomic.AtomicBoolean;

public class MyLockCompareAndSwap {
    private boolean locked = false;
    private AtomicBoolean atomicBoolean = new AtomicBoolean(false);

    public MyLockCompareAndSwap(boolean locked) {
        this.locked = locked;
    }

    public boolean lock() {
        if(!locked) {
            locked = true;
            return true;
        }
        return false;
    }

    public boolean safeLock() {//Equivalent to above method but safe
        atomicBoolean.compareAndSet(false, true);
        return atomicBoolean.get();

    }
}
