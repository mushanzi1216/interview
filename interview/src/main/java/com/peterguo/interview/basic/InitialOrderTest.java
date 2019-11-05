package com.peterguo.interview.basic;

/**
 * 类的初始化加载顺序
 * 静态变量、静态初始化块）>（变量、初始化块）>构造器。
 *
 * 有继承情况话的类初始化加载顺序
 * 父类的静态变量、静态初始化快> 子类的静态变量、静态初始化快 > 父类的变量、初始化块 、构造器 > 子类的变量 、初始化块 、构造器
 */
public class InitialOrderTest extends FatherInitialOrder {

        /* 静态变量 */
        public static String staticField = "静态变量";
        /* 变量 */
        public String field = "变量";
        /* 静态初始化块 */
        static {
            System.out.println( staticField );
            System.out.println( "静态初始化块" );
        }
        /* 初始化块 */
        {
            System.out.println( field );
            System.out.println( "初始化块" );
        }
        /* 构造器 */
        public InitialOrderTest()
        {
            System.out.println( "构造器" );
        }


        public static void main( String[] args )
        {
            new InitialOrderTest();
        }

}

class FatherInitialOrder{

    /* 静态变量 */
    public static String staticField = "父类静态变量";
    /* 变量 */
    public String field = "父类变量";
    /* 静态初始化块 */
    static {
        System.out.println( staticField );
        System.out.println( "父类静态初始化块" );
    }
    /* 初始化块 */
    {
        System.out.println( field );
        System.out.println( "父类初始化块" );
    }

    public FatherInitialOrder() {
        System.out.println( "父类构造器" );
    }
}
