package com.peterguo.interview.java8.interfacedefault;

/**
 * java8 在接口中添加了默认的方法 实现类不需要实现这种方法
 */
public interface Formula {

    double calculate(int a);

    default double sqrt(double a) {
        return Math.sqrt(a);
    }

}
