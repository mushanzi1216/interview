package com.peterguo.interview.spring.primarylabel;

import org.springframework.stereotype.Service;

@Service
public class MyClass2 implements MyInterface {

    @Override
    public void myMethnd() {
        System.out.println("MyClass2 实现");
    }
}
