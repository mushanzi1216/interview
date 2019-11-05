package com.peterguo.interview.basic;

import java.util.*;

/**
 * map测试
 */
public class MapTest {

    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put(null,"2");
        map.put(null,"3"); //map允许key为null 但是只允许一个为null 多个null时会覆盖之前的value
        System.out.println(map.get(null));

        Map<String,String> treeMap = new TreeMap<>(); //默认是按照key的字母顺序排序

        treeMap.put("c","c12");
        treeMap.put("a","a111");
        treeMap.put("b","b11");

        treeMap.forEach((K,V) ->
                System.out.println(K + ": " + treeMap.get(K)));

        Map<String,String> linkedHashMap = new LinkedHashMap<>(3,0.75f,true);

        linkedHashMap.put("apple", "苹果");
        linkedHashMap.put("watermelon", "西瓜");
        linkedHashMap.put("banana", "香蕉");
        linkedHashMap.put("peach", "桃子");

        linkedHashMap.get("banana");
        linkedHashMap.get("apple");
//        linkedHashMap.get("watermelon");
//        linkedHashMap.get("peach");
//        linkedHashMap.get("apple");
//        linkedHashMap.get("apple");
//        linkedHashMap.get("watermelon");

        //按照访问的先后顺序排列 等同于LRU算法 即最近最少使用原则 按照最近最少使用的顺序由小到大排序
        //如果只是使用了部分元素 则遍历的规则是先按放入的顺序 再按照使用的顺序
        for (Map.Entry<String,String> entry:linkedHashMap.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

    }
}
