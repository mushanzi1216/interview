package com.peterguo.interview.designModel.singleton;

/**
 * 静态内部类实现
 *
 * 当 Singleton 类被加载时，静态内部类 SingletonHolder 没有被加载进内存。
 * 只有当调用 getUniqueInstance() 方法从而触发 SingletonHolder.INSTANCE 时 SingletonHolder 才会被加载，
 * 此时初始化 INSTANCE 实例，并且 JVM 能确保 INSTANCE 只被实例化一次
 *
 * 延时加载 线程安全由JVM提供
 */
public class InnerStaticClassSingleton {

    public InnerStaticClassSingleton() {
    }

    private static class SingleHolder{
        private static final InnerStaticClassSingleton SINGLETON = new InnerStaticClassSingleton();
    }

    public static InnerStaticClassSingleton getInstance(){
        return SingleHolder.SINGLETON;
    }
}
