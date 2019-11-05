package com.peterguo.interview.proxy.api;

public class UserService {

    //新增用户抽象方法
    public void addUser(String userName, String password){
        System.out.println("添加一个用户");
    }

    //删除用户抽象方法
    public void delUser(String userName){
        System.out.println("删除一个用户");
    }
}
