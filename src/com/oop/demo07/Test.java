package com.oop.demo07;

//静态导入包

import static java.lang.Math.random;
import static java.lang.Math.PI;

public class Test {
    public static void main(String[] args) {
        System.out.println(random());//不需要写Math.random()
        System.out.println(PI);
    }
    //被final修饰之后断子绝孙，无法被继承
}
