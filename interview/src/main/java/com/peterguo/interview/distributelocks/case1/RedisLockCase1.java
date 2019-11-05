package com.peterguo.interview.distributelocks.case1;

import com.peterguo.interview.distributelocks.RedisLock;
import com.peterguo.interview.distributelocks.constant.LockConstant;
import redis.clients.jedis.Jedis;

/**
 * 存在的问题 如果过获取该锁的客户端挂了 则该锁永远都不会被释放掉
 */
public class RedisLockCase1 extends RedisLock {

    public RedisLockCase1(Jedis jedis, String localKey) {
        super(jedis, localKey);
    }

    @Override
    public void lock() {
        while (true){
            String result = jedis.set(lockey,"value", LockConstant.NOT_EXIST);
            if(LockConstant.OK.equals(result)){
                System.out.println("加锁成功!");
                break;
            }
        }
    }

    @Override
    public void unlock() {
        jedis.del(lockey);
    }

}
