package com.peterguo.interview.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 翻转数组
 */
public class ReverseArray {

    public static void main(String[] args) {

        String [] needToReverseStr = new String[]{
                "dog", "lazy", "a", "over", "jumps", "fox", "brown", "quick", "A"
        };
        System.out.println("before reverse");
        Arrays.stream(needToReverseStr).forEach(str -> System.out.println(str));

        List<String> list = Arrays.asList(needToReverseStr);
        Collections.reverse(list); //重点在这里
        needToReverseStr = list.toArray(new String[0]);//没有指定类型的话会报错

        System.out.println("after reverse");
        Arrays.stream(needToReverseStr).forEach(str -> System.out.println(str));
    }
}
