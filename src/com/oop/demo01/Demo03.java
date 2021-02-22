package com.oop.demo01;

public class Demo03 {
    public static void main(String[] args) {

        //实际参数和形式参数的类型要求一致对应！
        int add = Demo03.add(2, 3);//实际参数
        System.out.println(add);

    }

    public static int add(int a, int b) {//形式参数
        return a + b;
    }
}
