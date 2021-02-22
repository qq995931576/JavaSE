package com.zheng.operator;

public class Demo03 {
    public static void main(String[] args) {
        //关系运算符返回的结果：正确True   错误Fulse   布尔值

        int a = 10;
        int b = 20;
        int c = 21;
        System.out.println(c % a); // 取余（模运算）   c/a   21/10 = 2...1
        System.out.println(a > b);
        System.out.println(a == b);
        System.out.println(a < b);
        System.out.println(a <= b);
        System.out.println(a >= b);
        System.out.println(a != b);
    }
}
