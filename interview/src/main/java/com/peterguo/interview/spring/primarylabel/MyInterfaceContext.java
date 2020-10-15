package com.peterguo.interview.spring.primarylabel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @createTime 2020-09-24
 * @auther peterguo
 * @Description
 */
@Component
public class MyInterfaceContext {

    private final Map<String,MyInterface> interfaceMap= new ConcurrentHashMap();


    @Autowired
    public MyInterfaceContext(Map<String,MyInterface> interfaceMap){
        System.out.println("注入了要-----------");
        this.interfaceMap.clear();
        interfaceMap.forEach(this.interfaceMap::put);
    }
}
