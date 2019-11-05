package com.peterguo.interview.distributelocks.case3;

import com.peterguo.interview.distributelocks.RedisLock;
import com.peterguo.interview.distributelocks.constant.LockConstant;
import redis.clients.jedis.Jedis;

/**
 * 释放锁不具有原子性
 */
public class RedisLockCase3 extends RedisLock {

    public RedisLockCase3(Jedis jedis, String localKey) {
        super(jedis, localKey);
    }

    @Override
    public void lock() {
        while (true){
            String result = jedis.set(lockey,lockValue, LockConstant.NOT_EXIST,LockConstant.SECONDS,60);
            if(LockConstant.OK.equals(result)){
                System.out.println(Thread.currentThread().getId() + "加锁成功！");
                break;
            }
        }
    }

    @Override
    public void unlock() {
        /**
         * 释放锁分为3个步骤  1通过key获取对应的value 2 比较是否为当前线程持有 3 删除key
         * 如果逻辑走到第二步时 进程1突然阻塞 直到该锁被释放掉 然后其他的进程仍可以获取该锁 等到进程1唤醒后直接删除了其他进程持有的锁
         * 同样会有RedisLockCase2的问题
         */
        if(lockValue == jedis.get(lockey)){
            jedis.del(lockey);
        }
    }

}
