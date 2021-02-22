package com.zheng.method;

public class Demo02 {
    public static void main(String[] args) {
        int result = max(10, 10);
        System.out.println(result);
    }


    public static int max(int a, int b) {
        int result = 0;
        if (a == b) {
            System.out.println("输入内容不符合标准");
            return 0;//终止方法
        }
        if (a > b) {
            result = a;
        } else {
            result = b;
        }
        return result; //return除了返回结果的功能还有终止方法
    }

}
