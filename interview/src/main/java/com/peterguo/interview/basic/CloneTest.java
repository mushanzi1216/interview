package com.peterguo.interview.basic;


import java.io.*;

/**
 * 1 深拷贝和浅拷贝
 *   对于基本数据类型来说 就是浅拷贝
 *   对于引用类型来说 clone只是copy的对象的引用  是完全相同的  如果被拷贝对象的值修改 拷贝出来的新对象的值也会被修改
 *   所以必须对引用对象再次进行拷贝
 *
 * 2 或者使用字节流的形式 需要clone的类需要实现Serializable接口
 *   需要注意的是 如果有引用的类的话 那么引用的类也必须要实现Serializable接口
 */
public class CloneTest {


    public static void main(String[] args) throws Exception{
        Persion persion = new Persion();
        Child child = new Child();
        child.setHeight(3);
        persion.setChild(child);
        Persion persion1 = (Persion) persion.clone();

        System.out.println(persion == persion1);
        System.out.println(persion.getChild() == persion1.getChild());
        System.out.println(persion.getChild().getHeight());
        System.out.println(persion1.getChild().getHeight());
        persion.getChild().setHeight(5);

        System.out.println(persion.getChild().getHeight());
        System.out.println(persion1.getChild().getHeight());

        Persion persion2 = (Persion) CloneUtils.clone(persion);
        System.out.println(persion == persion2);


    }
}


class Persion implements Cloneable,Serializable {
    private String name;
    private int age;
    private Child child;

    public Child getChild() {
        return child;
    }

    public void setChild(Child child) {
        this.child = child;
    }

    public Persion() {
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {

        Persion persion = (Persion)super.clone();
        persion.child = (Child) persion.getChild().clone();
        return persion;
    }
}

class Child implements Cloneable,Serializable{
    private int height;

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Child() {
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class CloneUtils {


    public static <T extends Serializable> T clone(T obj) {
        T cloneObj = null;
        try {
            //写入字节流
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(obj);
            oos.close();

            //分配内存,写入原始对象,生成新对象
            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());//获取上面的输出字节流
            ObjectInputStream ois = new ObjectInputStream(bais);

            //返回生成的新对象
            cloneObj = (T) ois.readObject();
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cloneObj;
    }
}
