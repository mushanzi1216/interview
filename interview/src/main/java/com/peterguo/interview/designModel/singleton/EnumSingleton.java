package com.peterguo.interview.designModel.singleton;

/**
 * 该实现可以防止反射攻击。在其它实现中，通过 setAccessible() 方法可以将私有构造函数的访问级别设置为 public，然后调用构造函数从而实例化对象，
 * 如果要防止这种攻击，需要在构造函数中添加防止多次实例化的代码。
 * 该实现是由 JVM 保证只会实例化一次，因此不会出现上述的反射攻击
 */
public enum  EnumSingleton {

    INSTANCE;

    private String objName;


    public String getObjName() {
        return objName;
    }


    public void setObjName(String objName) {
        this.objName = objName;
    }

    public static void main(String[] args) {

        // 单例测试
        EnumSingleton firstSingleton = EnumSingleton.INSTANCE;
        firstSingleton.setObjName("firstName");
        System.out.println(firstSingleton.getObjName());
        EnumSingleton secondSingleton = EnumSingleton.INSTANCE;
        secondSingleton.setObjName("secondName");
        System.out.println(firstSingleton.getObjName());
        System.out.println(secondSingleton.getObjName());

        // 反射获取实例测试
        try {
            EnumSingleton[] enumConstants = EnumSingleton.class.getEnumConstants();
            for (EnumSingleton enumConstant : enumConstants) {
                System.out.println(enumConstant.getObjName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
