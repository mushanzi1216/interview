package com.peterguo.interview.basic;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 反射获取Class对象的3种形式
 * 反射的原理 通过字节码文件获取类的属性 方法等
 */
public class ReflectionTest {

    public static void main(String[] args) {

        //1 知道类的全路径
        try {

            Class home = Class.forName("com.peterguo.interview.basic.Home");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //2 知道类的名字
        Class home1 = Home.class;

        //3 通过实例获取
        Home home = new Home();
        Class home2 = home.getClass();


        /**
         * 获取类实例的2种方法
         */
        try {
            Home myHome = (Home) home1.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        try {
            Constructor constructor = home1.getConstructor(String.class);
            try {
                Home home3 = (Home) constructor.newInstance("广州");
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }


        /**
         * Class.forName 和 ClassLoader 的区别
         * 相同点: 都会将类加载到jvm中来
         * 不同点: Class.forName 会执行类中的静态代码块即可以初始化类 可以通过另外一个方法来设置是否初始化静态代码块
         */

        try {
            Class myHome = Class.forName("com.peterguo.interview.basic.Home");
            //Class myHome = Class.forName("com.peterguo.interview.basic.Home",false,Thread.currentThread().getContextClassLoader());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Class myHome1 = ClassLoader.getSystemClassLoader().loadClass("com.peterguo.interview.basic.Home");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
