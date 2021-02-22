package com.oop.demo01;

import java.io.IOException;

//Demo01 类
public class Demo01 {

    //main 方法
    public static void main(String[] args) {

    }


    /*
    修饰符  返回值类型  方法名（...）{
       //方法体
       return 返回值;
    }
     */
    //return结束方法,返回一个结果！
    public String sayHello() {
        return "Hello,World";
    }

    public void print() {
        return;
    }

    public int max(int a, int b) { //a,b形式参数
        return a > b ? a : b;//三元运算符
    }

    //数组下标越界：Arrayindexoutofbounds
    //异常抛出
    public void readFile(String file) throws IOException {

    }
}
