package com.peterguo.interview.mulithread.cas;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

public class CasABATest {

    public static AtomicInteger a = new AtomicInteger(1);

    public static AtomicStampedReference<Integer> b = new AtomicStampedReference<Integer>(1,0);

    private static CountDownLatch countDownLatch = new CountDownLatch(1);

    public static void main(String[] args) {
        Thread main = new Thread(() ->{
            System.out.println("操作线程: " + Thread.currentThread() + " ,初始值 = " + a);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            boolean isCASSuccess = a.compareAndSet(1,2); //会修改成功 但是已经与之前的情景不同了 既值被修改过
            System.out.println("操作线程: " + Thread.currentThread() + " ,CAS操作结果: " + isCASSuccess + " ,a=" + a);
        },"主线程");

        Thread other = new Thread(() ->{
            a.incrementAndGet();
            System.out.println("操作线程: " + Thread.currentThread() + " ,值 = " + a);
            a.decrementAndGet();
            System.out.println("操作线程: " + Thread.currentThread() + " ,值 = " + a);
        },"干扰线程");

        Thread main1 = new Thread(() ->{
            System.out.println("操作线程: " + Thread.currentThread() + " ,初始值 = " + a);
            int stamp = b.getStamp();

            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            boolean isCASSuccess = b.compareAndSet(1,2,stamp,stamp+1); //会修改失败 虽然值相同但是stamp版本号不同了
            System.out.println("操作线程: " + Thread.currentThread() + " ,CAS操作结果: " + isCASSuccess + " ,b=" + b.getReference());
        },"主线程1");

        Thread other1 = new Thread(() ->{
            b.compareAndSet(1,2,b.getStamp(),b.getStamp() + 1);
            System.out.println("操作线程: " + Thread.currentThread() + " ,值 = " + b.getReference());
            b.compareAndSet(2,1,b.getStamp(),b.getStamp() + 1);
            System.out.println("操作线程: " + Thread.currentThread() + " ,值 = " + b.getReference());

            countDownLatch.countDown();
        },"干扰线程1");

//        main.start();
//        other.start();

        main1.start();
        other1.start();
    }
}
