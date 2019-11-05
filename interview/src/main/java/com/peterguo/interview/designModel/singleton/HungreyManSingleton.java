package com.peterguo.interview.designModel.singleton;

/**
 * 饿汉模式
 *
 * 直接静态声明 避免引起多线程不安全 但是没有了延时加载的好处
 */
public class HungreyManSingleton {

    private static HungreyManSingleton hungreyManSingleton = new HungreyManSingleton();

    public static HungreyManSingleton getInstance(){
        return hungreyManSingleton;
    }
}
