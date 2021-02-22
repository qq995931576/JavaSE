package com.zheng.struct;

public class BreakDemo {
    public static void main(String[] args) {
        int i = 0;
        while (i < 100) {
            i++;
            System.out.println(i);
            if (i == 30) {
                break;//终止循环
            }
        }
        System.out.println("123"); //只是终止了循环 循环外还会执行输出
    }
}
