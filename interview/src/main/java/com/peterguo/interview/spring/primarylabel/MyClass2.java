package com.peterguo.interview.spring.primarylabel;

public class MyClass2 implements MyInterface {

    public MyClass2() {
        System.out.println("MyClass2 构造方法");
    }

    @Override
    public void myMethnd() {
        System.out.println("MyClass2 实现");
    }
}
