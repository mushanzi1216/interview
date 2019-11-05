package com.peterguo.interview.spring.primarylabel;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PrimaryTest {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfig.class);
        MyInterface myInterface = (MyInterface) applicationContext.getBean("myinterface");
        myInterface.myMethnd();
    }
}
