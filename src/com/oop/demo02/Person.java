package com.oop.demo02;

//java ---> class
public class Person {
    //一个类及时什么都不写，它也会存在一个方法
    //显示的定义构造器
    String name;
    int age;

    //构造器作用：
    //1. 使用new关键字，本质是在调用构造器
    //2. 构造器一般用来初始化值

    //无参构造器
    public Person() {

    }

    //有参构造:一但定义了有参构造，无参构造就必须显示定义
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //alt + Insert 一键生成有参 或 无参

}

/*
    //一个项目应该只存在一个mian方法
    public static void main(String[] args) {
        //new 实例化了一个对象
        Person person = new Person("阿昌",21); //它会自动判断调用无参还是有参构造

        System.out.println(person.name);//阿昌
        System.out.println(person.age);//21

    }

    构造器：
    特点：
        1. 和类名相同
        2. 没有返回值
    作用：
        1. new 本质在调用构造器
        2. 初始化对象的值
    注意点：
        1.定义了有参构造之后，如果想使用无参构造，必须要显示的定义一个无参构造（写一个无参）

    alt + Insert

    this.XXX = 参数传进来的值


 */
