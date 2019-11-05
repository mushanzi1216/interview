package com.peterguo.interview.java8.predicate;

import java.util.function.Predicate;

public class PredicateTest {

    public static void main(String[] args) {
        Predicate<String> predicate = s -> s.length() > 0;

        System.out.println(predicate.test("123"));
        System.out.println(predicate.test(""));

        /**
         * isEqual也是返回一个Predicate类型的比较器 然后通过equals方法覆盖掉接口中的apply方法
         */
        System.out.println(Predicate.isEqual(2).test(3));
        System.out.println(Predicate.isEqual("abc").test("abc"));
    }
}
