package com.peterguo.interview.mulithread.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {

    private int count = 0;

    private AtomicInteger atomicInteger  = new AtomicInteger(0);

    private volatile int count1 = 0;

    public int getCount1() {
        return count1;
    }

    public AtomicInteger getAtomicInteger() {
        return atomicInteger;
    }

    public void increAtomicInteger() {
        this.atomicInteger.incrementAndGet();
    }

    public int getCount() {
        return count;
    }

    public void increCount() {
        //System.out.println("before add: " + count);
        count++;
        increAtomicInteger();
        increCount1();
        //System.out.println("after add: " + count);
    }

    public synchronized void increCount1(){
        count1++;
    }
}
