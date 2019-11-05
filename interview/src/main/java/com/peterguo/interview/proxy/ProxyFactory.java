package com.peterguo.interview.proxy;

import com.peterguo.interview.proxy.api.User;

public interface ProxyFactory {

    <T extends User> T getProxy(T t);
}
