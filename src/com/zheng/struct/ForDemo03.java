package com.zheng.struct;

public class ForDemo03 {
    public static void main(String[] args) {
        //练习2：用while或for循环输出1-1000之间能被5整除的数，并且每行输出3个

        //for循环
        for (int i = 0; i <= 1000; i++) {
            if (i % 5 == 0) {
                System.out.print(i + "\t");// "\t"：tab的功能
            }
            if (i % 15 == 0) {
                System.out.print("\n"); // "\n"换行
            }
        }
        //println 输出换行
        //print 输出不换行

    }
}

