package com.peterguo.interview.distributelocks;

import redis.clients.jedis.Jedis;

import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public abstract class RedisLock implements Lock {

    protected Jedis jedis;
    protected String lockey;
    protected String lockValue;

    public RedisLock(Jedis jedis, String localKey) {
        this(jedis,localKey, UUID.randomUUID().toString());
    }

    public RedisLock(Jedis jedis, String lockey, String lockValue) {
        this.jedis = jedis;
        this.lockey = lockey;
        this.lockValue = lockValue;
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public Condition newCondition() {
        return null;
    }

}
