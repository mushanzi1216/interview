package com.peterguo.interview.proxy.api;

public interface UserManager extends User{

    //新增用户抽象方法
    void addUser(String userName,String password);
    //删除用户抽象方法
    void delUser(String userName);
}