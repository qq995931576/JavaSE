package com.zheng.base;

public class Demo04 {
    public static void main(String[] args) {
        //操作比较大的数的时候，注意溢出问题
        //JDK7新特性，数值之间可以用下划线分割
        int money = 10_0000_0000;
        int years = 20;
        int total = money * years;//-1474836480，计算溢出
        System.out.println(total);
        long total2 = money * years;
        System.out.println(total2);//-1474836480,默认在计算用是int类型，已经完成溢出计算，后再转换成Long

        long total3 = money * (long) years; //先把一个数转换为Long
        System.out.println(total3);//20000000000  正确

        // L l 尽量用大写字母表示
    }
}
