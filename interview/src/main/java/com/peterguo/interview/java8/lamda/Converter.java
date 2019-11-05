package com.peterguo.interview.java8.lamda;

/**
 * 如果该接口有大于1个方法时 当在这个接口上添加@FunctionalInterface 注解时会报编译错误
 * 但是这个注解并不是必须的如果去掉现在的@FunctionalInterface注解 JVM仍然可以认识他是一个函数式的接口
 * @param <F>
 * @param <T>
 */

@FunctionalInterface
public interface Converter<F,T> {

    T convert(F from);

    default T toF(T to){
        return to;
    }

}
