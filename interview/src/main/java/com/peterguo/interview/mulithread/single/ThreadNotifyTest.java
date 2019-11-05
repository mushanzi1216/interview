package com.peterguo.interview.mulithread.single;

public class ThreadNotifyTest {

    public synchronized void wait0(){
        System.out.println(Thread.currentThread().getName() + " 线程开始");
        try {
            wait(0); //使线程一直处于阻塞状态
            //Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " 线程停止");
    }

    public static void main(String[] args) {
        ThreadNotifyTest threadNotifyTest = new ThreadNotifyTest();
        for(int i=0;i<5;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                  threadNotifyTest.wait0();
                }
            }).start();
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("等待线程全部启动");
        System.out.println("执行notify");
        synchronized (threadNotifyTest){
            threadNotifyTest.notify();
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("执行notifyAll");
        synchronized (threadNotifyTest){
            threadNotifyTest.notifyAll();
        }
    }
}
