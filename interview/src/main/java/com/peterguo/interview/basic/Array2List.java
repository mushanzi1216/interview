package com.peterguo.interview.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Array2List {


    public static void main(String[] args) {

        /** list转数组 **/
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("11");
        list.add("111");

        String[] strArrays = list.toArray(new String[list.size()]);
        Arrays.stream(strArrays).forEach(s -> System.out.println(s));

        /** 数组转list **/
        Integer[] array1 = {1,2,3};
        int[] array2 = {1,2,3};
        //int[] array1 = {1,2,3}; 如果是原始类型的那么会编译不通过,因为下边声明的list里的类型是Integer
        //List<Integer> integerList = Arrays.stream(array2).boxed().collect(Collectors.toList()); 可以用stream提供的自动装箱方法将原始类型转换成包装类
        //List<Integer> integerList = Arrays.stream(array1).collect(Collectors.toList()); //另外一种转换方式
        List<Integer> integerList = Arrays.asList(array1);
        //integerList.add(4); //如果操作转换后的list 增删改均会报java.lang.UnsupportedOperationException 因为该类并不是默认的ArrayList集合,而是Arrays内部维护的一个内部类
        integerList.stream().forEach(integer -> System.out.println(integer));


        /** 当传入的是一个原始类型的数组时,得到的list就是这个数组本身 **/
        int[] originalIntArray = { 1, 2, 3 };  //原始类型
        List myList = Arrays.asList(originalIntArray);
        System.out.println(myList.size());
        System.out.println(myList.get(0));
        //System.out.println(myList.get(1));//报错：ArrayIndexOutOfBoundsException
        int [] array = (int[]) myList.get(0);
        System.out.println(array[0]);
    }
}
