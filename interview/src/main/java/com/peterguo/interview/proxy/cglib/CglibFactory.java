package com.peterguo.interview.proxy.cglib;

import com.peterguo.interview.proxy.ProxyFactory;
import com.peterguo.interview.proxy.api.User;
import net.sf.cglib.proxy.Enhancer;

public class CglibFactory implements ProxyFactory {


    @Override
    public <T extends User> T getProxy(T t) {
        Enhancer eh = new Enhancer();
        eh.setSuperclass(t.getClass());
        eh.setCallback(new CglibProxy());

        T userService = (T)eh.create();
        return userService;
    }
}
