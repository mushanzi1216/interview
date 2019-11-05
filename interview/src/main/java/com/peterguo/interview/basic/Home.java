package com.peterguo.interview.basic;

public class Home {

    static {
        System.out.println("执行静态代码块!!!");
    }

    public Home() {
    }

    public Home(String address) {
        this.address = address;
    }

    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
