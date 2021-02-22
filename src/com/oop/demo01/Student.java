package com.oop.demo01;

//学生类
public class Student {

    //静态方法
    public static void say() {
        System.out.println("学生说话了");
    }


    //非静态方法  想要调用需要实例化这个类new
    //new Student().hello();
    //对象类型  对象名  =  对象值

    //Student student = new Student();
    //student.say();
    public void hello() {
        System.out.println("hello，world");
    }

}
