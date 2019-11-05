package com.peterguo.interview.distributelocks.case4;

import com.peterguo.interview.distributelocks.RedisLock;
import com.peterguo.interview.distributelocks.constant.LockConstant;
import redis.clients.jedis.Jedis;

/**
 * 解决删除key原子性问题 但是业务时间如何大于过期时间仍未解决
 */
public class RedisLockCase4 extends RedisLock {

    public RedisLockCase4(Jedis jedis, String localKey) {
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
        // 使用lua脚本进行原子删除操作
        String checkAndDelScript = "if redis.call('get', KEYS[1]) == ARGV[1] then " +
                "return redis.call('del', KEYS[1]) " +
                "else " +
                "return 0 " +
                "end";
        jedis.eval(checkAndDelScript, 1, lockey, lockValue);

    }

}
