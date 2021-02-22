package com.zheng.struct;

public class ForDemo04 {
    public static void main(String[] args) {
        //while循环
        int k = 0;
        while (k <= 1000) {
            if (k % 5 == 0) {
                System.out.print(k + "\t");
            }
            if (k % 15 == 0) {
                System.out.println();
            }
            k++;
        }
    }
}
