package com.peterguo.interview.basic;

/**
 * 输出各种基础类型的bit大小，也就是所占二进制的位数,1Byte=8bit
 */
public class BasicTypeBit {

    public static void main(String[] args) {
        System.out.println("Byte : " + Byte.SIZE);
        System.out.println("Char : " + Character.SIZE);
        System.out.println("Short : " + Short.SIZE);
        System.out.println("Integer : " + Integer.SIZE);
        System.out.println("Float : " + Float.SIZE);
        System.out.println("Long : " + Long.SIZE);
        System.out.println("Double : " + Double.SIZE);
        //boolean 表示的是一个比特的信息
    }
}
