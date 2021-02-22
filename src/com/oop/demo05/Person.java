package com.oop.demo05;

//Person 人  ： 基类，父类
public class Person {

    public Person() {
        System.out.println("Person类无参执行了");
    }

    protected String name = "阿昌";

    //私有的东西无法被继承！
    public void print() {
        System.out.println("Person");
    }
}
