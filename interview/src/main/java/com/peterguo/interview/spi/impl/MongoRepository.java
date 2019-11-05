package com.peterguo.interview.spi.impl;

import com.peterguo.interview.spi.IRepository;

public class MongoRepository implements IRepository {

    @Override
    public void save(String data) {
        System.out.println("save " + data + " to mongo");
    }
}
