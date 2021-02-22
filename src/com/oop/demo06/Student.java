package com.oop.demo06;

public class Student extends Person {
    public void go() {
        System.out.println("go");
    }
}




/*

    public static void main(String[] args) {

        //Object > String
        //Object > Person > Teacher
        //Object > Person > Student
        Object object = new Student();

        System.out.println(object instanceof Student);//true
        System.out.println(object instanceof Person);//true
        System.out.println(object instanceof Object);//true
        System.out.println(object instanceof Teacher);//false
        System.out.println(object instanceof String);//false

        System.out.println("==============================");

        Person person = new Student();
        System.out.println(person instanceof Student);//true
        System.out.println(person instanceof Person);//true
        System.out.println(person instanceof Object);//true
        System.out.println(person instanceof Teacher);//false
        //System.out.println(person instanceof String);编译报错

        System.out.println("==============================");

        Student student = new Student();
        System.out.println(student instanceof Student);//true
        System.out.println(student instanceof Person);//true
        System.out.println(student instanceof Object);//true
        //System.out.println(student instanceof Teacher);编译报错
        //System.out.println(student instanceof String);编译报错

        //System.out.println(X instanceof Y); 能不能编译通过取决于 X 与 Y是否存在父子关系
    }

 */
