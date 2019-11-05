package com.peterguo.interview.distributelocks;

import com.peterguo.interview.distributelocks.case5.RedisLockCase5;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class RedisLockCase5Test {

    private String lockName = "redisLock";

    @Before
    public void showExpiredTime(){
        new Thread(() ->{
            while (true){
                Jedis jedis = new Jedis("192.168.0.210",6379);
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("锁的过期时间:" + jedis.ttl(lockName) + "秒");
            }
        }).start();
    }

    @Test
    public void testLockCase5(){
        //定义线程池
        ThreadPoolExecutor pool = new ThreadPoolExecutor(0, 10,
                1, TimeUnit.SECONDS,
                new SynchronousQueue<>());

        //添加10个线程获取锁
        for (int i = 0; i < 5; i++) {
            pool.submit(() -> {
                try {
                    Jedis jedis = new Jedis("192.168.0.210",6379);
                    RedisLockCase5 lock = new RedisLockCase5(jedis, lockName);
                    lock.lock();

                    //模拟业务执行15秒
                    Thread.sleep(15 * 1000);

                    lock.unlock();
                } catch (Exception e){
                    e.printStackTrace();
                }
            });
        }

        //当线程池中的线程数为0时，退出
        while (pool.getPoolSize() != 0) {}
    }
}
