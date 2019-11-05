package com.peterguo.interview.java8.lamda;

public interface PersonFacory<T extends Person> {

    T  create(String name,String address);
}
