package com.peterguo.interview.spring.primarylabel;

import org.springframework.stereotype.Service;

@Service
public class MyClass1 implements MyInterface {

    @Override
    public void myMethnd() {
        System.out.println("MyClass1 实现");
    }
}
