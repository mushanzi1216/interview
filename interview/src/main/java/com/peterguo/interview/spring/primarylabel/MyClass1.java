package com.peterguo.interview.spring.primarylabel;

public class MyClass1 implements MyInterface {

    public MyClass1() {
        System.out.println("MyClass1 构造方法");
    }

    @Override
    public void myMethnd() {
        System.out.println("MyClass1 实现");
    }
}
