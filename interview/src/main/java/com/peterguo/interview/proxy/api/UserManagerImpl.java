package com.peterguo.interview.proxy.api;

public class UserManagerImpl implements UserManager {
    @Override
    public void addUser(String userName, String password) {
        System.out.println("添加一个用户");
    }

    @Override
    public void delUser(String userName) {
        System.out.println("删除一个用户");
    }
}
