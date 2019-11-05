package com.peterguo.interview.mulithread.atomic;

public class ThreadB implements Runnable {

    private AtomicIntegerTest atomicIntegerTest;

    public ThreadB(AtomicIntegerTest atomicIntegerTest) {
        this.atomicIntegerTest = atomicIntegerTest;
    }

    @Override
    public void run() {
        System.out.println("这是线程b");
        for(int i = 0;i< 10000;i++){
            atomicIntegerTest.increCount();
        }
        System.out.println("线程b执行完了");

    }
}
