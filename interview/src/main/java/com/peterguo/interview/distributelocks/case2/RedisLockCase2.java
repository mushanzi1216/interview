package com.peterguo.interview.distributelocks.case2;

import com.peterguo.interview.distributelocks.RedisLock;
import com.peterguo.interview.distributelocks.constant.LockConstant;
import redis.clients.jedis.Jedis;

/**
 * 解决了锁不能超时释放问题
 * 仍存在的问题:
 *  1 如何保证锁不会被误删除
 *      e.g 客户端1获取锁 突然出现长时间的gc 一直到该锁过期时间到后被释放 然后客户端2获取该锁 此时客户端1被唤醒 释放了本来在客户端2中的锁
 *  2 过期时间如何保证大于业务处理的时间
 *      e.g 客户端业务较复杂需要处理100s 但是锁的有效期只有60s 在第60s时锁就被释放掉了 其他的客户端仍然可以获取该锁
 */
public class RedisLockCase2 extends RedisLock {

    public RedisLockCase2(Jedis jedis, String localKey) {
        super(jedis, localKey);
    }

    @Override
    public void lock() {
        while (true){

            /**
             * 这里的设置key 和过期时间的操作需要保证操作的原子性 即使用setnx命令
             * 从而解决 RedisLockCase1的问题
             * @see com.peterguo.interview.distributelocks.case1.RedisLockCase1
             */
            String result = jedis.set(lockey,"value", LockConstant.NOT_EXIST,LockConstant.SECONDS,60);
            if(LockConstant.OK.equals(result)){
                System.out.println("加锁成功！");
                break;
            }
        }
    }

    @Override
    public void unlock() {
       jedis.del(lockey);
    }
}
