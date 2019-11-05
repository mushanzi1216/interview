package com.peterguo.interview.designModel.singleton;

/**
 * 双重检查锁-线程安全
 *
 * 只对实例化的模块进行加锁 效率较高
 *
 */
public class DoubleCheckSingeton {

    /**
     * 1 为 doubleCheckSingeton 分配内存空间
     * 2 初始化 doubleCheckSingeton
     * 3 将 doubleCheckSingeton 指向分配的内存地址
     *
     * 但是由于 JVM 具有指令重排的特性，执行顺序有可能变成 1>3>2。指令重排在单线程环境下不会出现问题，但是在多线程环境下会导致一个线程获得还没有初始化的实例。例如，线程 T1 执行了 1 和 3，此时 T2 调用 getUniqueInstance() 后发现 uniqueInstance 不为空，因此返回 uniqueInstance，但此时 uniqueInstance 还未被初始化。
     * 使用 volatile 可以禁止 JVM 的指令重排，保证在多线程环境下也能正常运行
     */
    private static volatile DoubleCheckSingeton doubleCheckSingeton;

    public static DoubleCheckSingeton getInstance(){
        if(null == doubleCheckSingeton){
            synchronized (DoubleCheckSingeton.class){
                if(doubleCheckSingeton == null){
                    doubleCheckSingeton = new DoubleCheckSingeton();
                }
            }
        }

        return doubleCheckSingeton;
    }
}
