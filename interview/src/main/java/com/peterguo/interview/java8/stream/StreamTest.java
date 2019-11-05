package com.peterguo.interview.java8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest {

    /**
     * strem 接口只支持Collection集合类 所以map是不支持的
     * @param args
     */
    public static void main(String[] args) {

        //先准备一些数据
        List<String> stringList = new ArrayList<>();
        stringList.add("ddd2");
        stringList.add("aaa2");
        stringList.add("bbb1");
        stringList.add("aaa1");
        stringList.add("bbb3");
        stringList.add("ccc");
        stringList.add("bbb2");
        stringList.add("ddd1");


        stringList.stream().forEach(System.out::print);
        stringList.stream().forEach(s -> s.toUpperCase()); //forEach属于最终操作了 因为不能聚合起来操作过后的值
        stringList.stream().map(s -> s.toUpperCase()).collect(Collectors.toList()); //map属于中间操作 还是返回的strem类型 所以如果想对stream中的值进行操作并且返回他们的话 需要使用map

        boolean anyStartsWithA =
                stringList
                        .stream()
                        .anyMatch((s) -> s.startsWith("a"));
        System.out.println(anyStartsWithA);      // true
    }
}
