package com.zheng.operator;

public class Demo07 {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;

        a += b; //a=a+b
        a -= b; //a=a-b
        System.out.println(a); //10     a+b-b=10

        //字符串连接符  +  ， String
        System.out.println("" + a + b);//1020
        System.out.println(a + b + "");//30
        //上面有什么区别？ →从左向右顺序计算String会转换别的类型为String
    }
}
