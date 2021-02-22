package com.oop.demo01;

public class Demo02 {

    //静态方法  Static

    //非静态方法
    public static void main(String[] args) {
        //实例化这个类 new
        //对象类型  对象名  =  对象值
        Student student = new Student();

        student.say();
    }

    //和类一起加载
    public static void a() {
        Demo02 b = new Demo02();//要new出 b 直接调用b会报错

    }

    //类实例化 之后才存在
    public void b() {

    }
}
