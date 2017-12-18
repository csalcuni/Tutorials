package it.scp.tests;

import java.util.concurrent.atomic.AtomicInteger;

public class CountCheck {
    private final AtomicInteger atomicInteger = new AtomicInteger();

    public void initialize(int value) {
        atomicInteger.set(value);
    }

    public void addOne() {
        atomicInteger.incrementAndGet();
    }

    public int getCount() {
        return atomicInteger.get();
    }
}
