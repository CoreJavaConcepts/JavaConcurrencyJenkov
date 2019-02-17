package com.java.atomicvariables;

public class InfoCode {

    //How Atomic integer works without lock
    /*public final int getAndIncrement() {
        for (;;) {
            int current = get();
            int next = current + 1;
            if (compareAndSet(current, next))
                return current;
        }
    }*/
}
