package com.zheng.struct;

public class DoWhileDemo02 {
    public static void main(String[] args) {
        int a = 0;
        while (a < 0) { //未满足条件无法执行
            System.out.println(a);
            a++;
        }
        System.out.println("======================");
        do { //先执行，判断是否满足条件
            System.out.println(a);  // 0
            a++;
        } while (a < 0);
    }
}
