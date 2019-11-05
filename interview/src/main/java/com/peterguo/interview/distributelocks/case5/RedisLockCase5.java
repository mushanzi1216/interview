package com.peterguo.interview.distributelocks.case5;

import com.peterguo.interview.distributelocks.RedisLock;
import com.peterguo.interview.distributelocks.constant.LockConstant;
import redis.clients.jedis.Jedis;

import java.time.LocalTime;


/**
 * 增加一个定时刷新过期时间任务 每隔10s检查业务逻辑是否已经完成 如果未完成则将该key重新设置过期时间
 */
public class RedisLockCase5 extends RedisLock {

    private volatile boolean isOpenExpirationRenewal = true; //是否启动过期策略自动刷新

    public RedisLockCase5(Jedis jedis, String localKey) {
        super(jedis, localKey);
    }

    @Override
    public void lock() {
        while (true){
            String result = jedis.set(lockey,lockValue, LockConstant.NOT_EXIST,LockConstant.SECONDS,60);
            long threadId = Thread.currentThread().getId();

            if(LockConstant.OK.equals(result)){
                System.out.println(threadId + "加锁成功！,加锁时间: " + LocalTime.now());

                isOpenExpirationRenewal = true;
                scheduleExpirationRenewal(threadId);

                break;
            }

            System.out.println(threadId + "加锁失败，加锁时间: " + LocalTime.now());
            try {
                Thread.sleep(10 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
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
        System.out.println(Thread.currentThread().getId() + " 解锁成功，解锁时间: " + LocalTime.now());
        isOpenExpirationRenewal = false;

    }

    /**
     * 开启自动刷新过期时间任务 每10秒执行一次
     */
    private void scheduleExpirationRenewal(long threadId){
        new Thread(() ->{
            while (isOpenExpirationRenewal){
                System.out.println(threadId + "执行延迟失效时间中...");

                String checkAndExpireScript = "if redis.call('get', KEYS[1]) == ARGV[1] then " +
                        "return redis.call('expire',KEYS[1],ARGV[2]) " +
                        "else " +
                        "return 0 end";
                jedis.eval(checkAndExpireScript, 1, lockey, lockValue, "60");

                try {
                    Thread.sleep(10 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
