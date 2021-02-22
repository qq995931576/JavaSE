package com.oop.demo05;

//学生 is 人 ： 派生类，子类
//子类继承了父类，就会拥有父类的全部方法！
public class Student extends Person {

    public Student() {
        //隐藏代码：调用了父类的无参构造
        super();//调用父类的构造器，必须要在子类构造器的第一行
        System.out.println("Stduent子类无参执行了");
    }


    private String name = "彦昌";

    public void print() {
        System.out.println("Student");
    }

    public void test1() {
        print();//Student      当前Student子类的print方法
        this.print();//Student 当前Student子类的print方法
        super.print();//Person Person父类的print方法

    }

    public void test(String name) {

        System.out.println(name);//yanchang 当前输入方法的实例参数
        System.out.println(this.name);//彦昌 当前子类的name
        System.out.println(super.name);//阿昌 Person父类的name
    }
}
