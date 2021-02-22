package com.oop.demo07;

public class Person {

    //第二个执行 赋初始值
    {
        System.out.println("匿名代码块");//代码块（匿名代码块）
    }

    //第一个执行，且只执行一次
    static {
        System.out.println("静态代码块");//静态代码块
    }

    //第三个执行
    public Person() {
        System.out.println("构造方法");
    }

    public static void main(String[] args) {
        Person person1 = new Person();
        System.out.println("====================");
        Person person2 = new Person();
    }
}
