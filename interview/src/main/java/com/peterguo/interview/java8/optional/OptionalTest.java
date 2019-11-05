package com.peterguo.interview.java8.optional;

import com.peterguo.interview.java8.lamda.Person;
import com.peterguo.interview.java8.lamda.PersonFacory;

import java.util.Optional;

public class OptionalTest {

    public static void main(String[] args) {


        /**
         * 小结：使用 Optional 时尽量不直接调用 Optional.get() 方法, Optional.isPresent()
         * 这两个方法更被认为是私有的方法 使用起来不是很优雅
         *
         * 最好使用orElse map orElseGet等
         */
        PersonFacory<Person> personFacory = Person::new;
        Person person = personFacory.create("peter","china");

        //三种创建方式
        Optional.ofNullable(person); //允许为空
        Optional.of(person); //不允许为空
        Optional.empty();   //一个空的optional对象

        String myAddress = Optional.ofNullable(person)
                .map(person1 -> person.getAddress())
                .map(address -> address.toUpperCase())
                .orElse(""); //而不是 return user.isPresent() ? user.get() : null;

        System.out.println("myAddress: " + myAddress);

        Optional<Person> optionalPerson = Optional.ofNullable(person);

        optionalPerson.orElse(person);
        optionalPerson.orElseGet(() ->{
            System.out.println("do something other!!!!"); //与orElse的差别 可以在optional为空时添加一些其他逻辑后在返回默认的值
            return person;
        });
        optionalPerson.ifPresent(person1 -> System.out.println(person1.getAddress())); //当存在时才执行一些操作

        //而不要下边那样
        //if (optionalPerson.isPresent()) {
        //    System.out.println(optionalPerson.get());
        //}

    }
}
