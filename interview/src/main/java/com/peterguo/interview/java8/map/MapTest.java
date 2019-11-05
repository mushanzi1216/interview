package com.peterguo.interview.java8.map;

import java.util.HashMap;
import java.util.Map;

public class MapTest {

    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<>();

        map.put(1,"张三");
        map.put(2,"李四");

        map.forEach((key,value) -> {
            System.out.println("key: " + key + " value: " + value);
        });

        map.putIfAbsent(1,"王五"); //如果对应的key存在的话 则不需要覆盖之前存在的值 底层实现是跟put同一个方法 不同的是有个参数 onlyIfAbsent 该值设置为了true

        map.forEach((key,value) -> {
            System.out.println("key: " + key + " value: " + value);
        });

        map.getOrDefault(42, "not found");  // 获取一个值不存在值给他一个默认值 貌似泉哥很喜欢用这个方法

    }
}
