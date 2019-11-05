package com.peterguo.interview.mulithread.atomic;

import java.lang.Thread;

/**
 * 使用atomiinteger的demo
 * 使用synchorized + volatile 也可以实现 但是效率较低
 */
public class AtomicIntegerBootstrap {

    public static void main(String[] args) {
        System.out.println("test not save integer");

        AtomicIntegerTest atomicIntegerTest = new AtomicIntegerTest();
        Thread threadA = new Thread(new ThreadA(atomicIntegerTest));
        Thread threadB = new Thread(new ThreadB(atomicIntegerTest));

        System.out.println("这是主线程");
        threadA.start();
        threadB.start();

        try {
            threadA.join();
            threadB.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线程执行完了");

        System.out.println("原始类型的计算结果是: " + atomicIntegerTest.getCount());
        System.out.println("使用了原子类型的计算结果是: " + atomicIntegerTest.getAtomicInteger());
        System.out.println("使用了synchrozied关键字的计算结果是: " + atomicIntegerTest.getCount1());
    }
}
