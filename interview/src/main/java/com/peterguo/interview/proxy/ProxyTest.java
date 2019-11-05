package com.peterguo.interview.proxy;

import com.peterguo.interview.proxy.api.UserManager;
import com.peterguo.interview.proxy.api.UserManagerImpl;
import com.peterguo.interview.proxy.cglib.CglibFactory;
import com.peterguo.interview.proxy.jdk.JdkProxyFactory;

public class ProxyTest {

    public static void main(String[] args) {

        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        JdkProxyFactory jdkProxyFactory = new JdkProxyFactory();
        UserManager user = jdkProxyFactory.getProxy(new UserManagerImpl());
        user.addUser("admin", "123123");

//        CglibFactory cglibFactory = new CglibFactory();
//        UserManager userService = cglibFactory.getProxy(new UserManagerImpl());
//        userService.addUser("admin1","11111");
//        userService.delUser("admin1");


    }
}
