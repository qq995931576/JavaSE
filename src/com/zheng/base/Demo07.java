package com.zheng.base;

public class Demo07 {
    //修饰符，不存在先后顺序（ double前面的static final）
    static final double PI = 3.14;
    String name;

    public static void main(String[] args) {
        Demo07 oni = new Demo07();
        oni.name = "mike";
        System.out.println(PI);
        System.out.println(oni.name);
    }
}
