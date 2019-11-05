package com.peterguo.interview.java8.interfacedefault;

public class InterfaceDefaultTest {

    public static void main(String[] args) {
        Formula formula = new Formula() {

            @Override
            public double calculate(int b) {
                return Math.sqrt(b);
            }
        };

        formula.calculate(16);
        formula.sqrt(100);
    }
}
