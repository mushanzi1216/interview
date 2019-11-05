package com.peterguo.interview.basic;

/**
 * 1 string类型使用+连接时在字节码文件中会生成多个stringbuilder对象 会占用大量的资源
 * 2 StringBuilder 和 StringBuffer 用法基本一样 StringBuffer是线程安全的
 * 3 StringBuffer线程安全是因为他增加了同步方法 即使用了synchronized关键字
 */
public class StringCompare {

    public static void main(String[] args) {
        String s1 = "a" + "b";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("a").append("b");

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("a").append("b");

        System.out.println("s1: " + s1);
        System.out.println("stringBuilder: " + stringBuilder);
        System.out.println("stringBuffer: " + stringBuffer);
    }
}
