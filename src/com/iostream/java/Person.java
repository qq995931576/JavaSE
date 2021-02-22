package com.iostream.java;

import java.io.Serializable;

/*

Person类需要满足如下的要求,方可序列化
1. 需要实现接口: Serializable
2. 需要当前类提供一个全局常量: serialVersionUID
3. 除了当前Person类需要实现Serializable接口之外,还必须保证其内部的所有属性
   也必须是可序列号的。(默认情况下,基本数据类型都可序列化)

补充:ObjectInputStream 和 ObjectOutputStream不能序列化static和transient修饰的成员变量


 */
public class Person implements Serializable {

    public static final long serialVersionUID = 454613272L;

    private String name;
    private Integer age;

    public Person() {
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
