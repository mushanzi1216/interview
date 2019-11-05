package com.peterguo.interview.basic;

public final class FinalTest {


    /**
     * 变量可以在声明的时候不初始化 但是在类初始化的时候必须初始化
     */
    public final int a;

    public FinalTest(int a) {
        this.a = a;
    }

    public static final int b = 4;
    // class SubFinalTest extends FinalTest{ } 不允许被继承

    public final void getValue(){ //改方法不可以被子类覆盖
        System.out.println("final 方法");
    }
    public static void main(String[] args) {
        FinalTest finalTest = new FinalTest(9);
        // finalTest.b = 4; final修饰的变量不能被重复赋值
    }
}
