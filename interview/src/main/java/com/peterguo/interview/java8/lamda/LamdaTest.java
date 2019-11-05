package com.peterguo.interview.java8.lamda;



public class LamdaTest {

    public static void main(String[] args) {

        //这种表示此时生成的是一个匿名内部类
        Converter<String, Integer> converter = new Converter<String, Integer>() {

            @Override
            public Integer convert(String from) {
                return Integer.valueOf(from);
            }
        };

        Converter<String, Integer> converter1 = from -> Integer.valueOf(from); //表示可以使用lamda表达式
        Converter<String, Integer> converter2 = Integer::new; //也可以用通过静态方法来引用

        Something something = new Something();
        Converter<String,String>  converter3 = something::startwith; //也可以通过对象的引用来实现
        String converted = converter3.convert("Java");
        System.out.println(converted);

        PersonFacory<Person> personFacory = Person::new;
        Person person = personFacory.create("张三","中国");


        int a = 2; //不同于匿名内部类 不加final修饰的局部变量在lamba表达式中也是可以访问到的
        Converter<String,Integer> converter4 = from -> a + Integer.valueOf(from);
        // a = 3; 但是不允许在lamda表达式之后修改局部变量的值

        //Formula formula = a1 -> sqrt(a1); lamda表达式是不支持使用接口的默认方法的

    }
}

class Something{

    String startwith(String s){
        return  String.valueOf(s.charAt(0));
    }
}
