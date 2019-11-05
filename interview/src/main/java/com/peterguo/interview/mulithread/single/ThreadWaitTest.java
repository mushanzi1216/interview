package com.peterguo.interview.mulithread.single;

public class ThreadWaitTest {

    public synchronized void wait0(){
        System.out.println("线程开始");
        try {
            wait(1000);
            //Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程停止");
    }

    public static void main(String[] args) {
        ThreadWaitTest threadWaitTest = new ThreadWaitTest();
        new Thread(new Runnable() {
            @Override
            public void run() {
                threadWaitTest.wait0();
            }
        }).start();
    }
}
