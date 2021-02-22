package com.zheng.method;

public class Demo06 {
    //阶乘
    //2! 2*1
    //3! 3*2*1
    //4! 4*3*2*1

    //递归思想
    public static void main(String[] args) {
        System.out.println(f(4));
    }

    public static int f(int n) {
        if (n == 1) {
            return 1; //递归头
        } else {
            return n * f(n - 1);//递归体
        }
    }
}
