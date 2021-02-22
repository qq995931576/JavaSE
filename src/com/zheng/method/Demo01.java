package com.zheng.method;

public class Demo01 {
    //main方法
    public static void main(String[] args) {

        int sum = add(1, 2);//实际参数1,2
        System.out.println(sum);
        System.out.println("============================");

        finka(); //调用自己自定义的函数方法finka
    }


    //自制加法方法函数的结构

    //      修饰符          +  返回值类型  + 命名
    //public static(类变量） +  int       + add（起个名字）
    public static int add(int aaa, int bbb) {//形式参数aaa，bbb
        return aaa + bbb;
    }

    //定义自定义函数方法finka

    public static void finka() {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i + "*" + j + "=" + (i * j) + "\t");
            }
            System.out.println();
        }
    }
}