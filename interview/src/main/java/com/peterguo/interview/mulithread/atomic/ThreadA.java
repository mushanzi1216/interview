package com.peterguo.interview.mulithread.atomic;

public class ThreadA implements Runnable {

    private AtomicIntegerTest atomicIntegerTest;

    public ThreadA(AtomicIntegerTest atomicIntegerTest) {
        this.atomicIntegerTest = atomicIntegerTest;
    }

    @Override
    public void run() {
        System.out.println("这是线程a");
        for(int i = 0;i< 10000;i++){
            atomicIntegerTest.increCount();
        }
        System.out.println("线程a执行完了");
    }
}
