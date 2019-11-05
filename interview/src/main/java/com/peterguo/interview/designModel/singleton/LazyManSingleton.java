package com.peterguo.interview.designModel.singleton;

/**
 * 懒汉单例模式
 * 存在线程安全问题
 * 可以在实例化方法中加synchronized方法来实现线程安全,但是效率较低 只有一个线程能够访问该方法
 */
public class LazyManSingleton {

    public LazyManSingleton() {
    }

    private static LazyManSingleton lazyManSingleton;

    public static LazyManSingleton getInstance(){
        if(null == lazyManSingleton){
            return new LazyManSingleton();
        }

        return lazyManSingleton;
    }
}
