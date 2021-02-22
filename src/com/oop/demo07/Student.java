package com.oop.demo07;

//static：

public class Student {

    private static int age;//静态变量   多线程
    private double score;//非静态变量

    public void run() {
    }

    public static void go() {
    }

    public static void main(String[] args) {
        go();//可直接调用此类中的静态方法

    }
}
