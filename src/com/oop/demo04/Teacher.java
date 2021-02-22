package com.oop.demo04;

//类     private：私有
public class Teacher {

    //属性私有

    private String name;//名字
    private int id;//学号
    private char sex;//性别
    private int age;//年龄

    //提供一些可以操作这个属性的方法
    //提供一些public 的 get、set方法

    //get 获得这个数据
    public String getName() {
        return this.name;
    }

    //set 给这个数据设置值
    public void setName(String name) {
        this.name = name;
    }
    //alt + Insert --->Getter and Setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 120 || age < 0) { //不合法
            this.age = 3;
        } else {
            this.age = age;
        }
    }
}