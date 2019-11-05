package com.peterguo.interview.java8.ConsumerAndSupplier;

import com.peterguo.interview.java8.lamda.Person;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class ConsumerAndSupplierTest {

    public static void main(String[] args) {


        //Consumer 强调的是对入参做一些操作 并不会返回操作完之后的值
        Consumer<String> stringConsumer = s -> System.out.println(s.length());
        stringConsumer.accept("java");

        //Supplier 强调的是返回一个给定的类型值
        Supplier<Person> integerSupplier = Person::new;
        integerSupplier.get();
    }
}
