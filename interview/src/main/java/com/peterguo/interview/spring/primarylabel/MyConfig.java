package com.peterguo.interview.spring.primarylabel;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class MyConfig {

    @Bean(name = "myinterface")
    public MyClass2 myInterface1(){
        return new MyClass2();
    };

    @Bean(name = "myinterface")
    public MyClass1 myInterface(){
        return new MyClass1();
    };


}
