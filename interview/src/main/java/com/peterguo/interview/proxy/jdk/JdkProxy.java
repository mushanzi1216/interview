package com.peterguo.interview.proxy.jdk;

import com.peterguo.interview.proxy.api.UserManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * JDK动态代理实现InvocationHandler接口
 */
public class JdkProxy implements InvocationHandler {

    private UserManager userManager;

    public JdkProxy(UserManager userManager) {
        this.userManager = userManager;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("JDK动态代理，监听开始！");
        Object result = method.invoke( this.userManager, args);
        System.out.println("JDK动态代理，监听结束！");
        return result;
    }

}
