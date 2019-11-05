package com.peterguo.interview.basic;

import java.util.*;

/**
 * equals判断规则
 */
public class EqualsTest {

    public static void main(String[] args) {
        String s1 = null;
        String s2 = "abc";
        //System.out.println(s1.equals(s2));  //这样会报空指针的错误

        System.out.println(s2.equals(s1)); //正常使用 不会报错
        System.out.println(Objects.equals(s1,s2)); //推荐使用 JDK7引入 对null友好处理


        String str1 = new String("abc");
        String str2 = new String("abc");
        Value value = new Value(2);
        Map<String,Value> valueMap = new HashMap<>();
        valueMap.put(str1,value);
        System.out.println(str1.equals(str2));
        System.out.println(valueMap.get(str1));
        System.out.println(valueMap.get(str2));


        Key key1 = new Key("abc");
        Key key2 = new Key("abc");
        Map<Key,Value> keyValueMap = new HashMap<>();
        keyValueMap.put(key1,value);
        System.out.println(key1.equals(key2));
        System.out.println(keyValueMap.get(key1));
        System.out.println(keyValueMap.get(key2));  //虽然重写了equals方法 但是hashcode方法未重写 因为内存地址不同 所以hashcode不同 取出来的值也不同

    }

    static class Key{
        String k;

        public Key(String k) {
            this.k = k;
        }

        public String getK() {
            return k;
        }

        public void setK(String k) {
            this.k = k;
        }

        @Override
        public boolean equals(Object obj) {
            if(obj instanceof Key){
                Key key = (Key)obj;
                return k.equals(key.k);
            }

            return false;
        }
    }

    static class Value{
        int v;

        public Value(int v) {
            this.v = v;
        }

        @Override
        public String toString() {
            return "Value{" +
                    "v='" + v + '\'' +
                    '}';
        }
    }
}
