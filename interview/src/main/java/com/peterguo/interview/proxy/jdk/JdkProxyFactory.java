package com.peterguo.interview.proxy.jdk;

import com.peterguo.interview.proxy.ProxyFactory;
import com.peterguo.interview.proxy.api.User;
import com.peterguo.interview.proxy.api.UserManager;

import java.lang.reflect.Proxy;

public class JdkProxyFactory implements ProxyFactory {

    @Override
    public <T extends User> T getProxy(T t) {

        T jdkProxy = (T)Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                t.getClass().getInterfaces(),new JdkProxy((UserManager) t));

        return jdkProxy;
    }
}
