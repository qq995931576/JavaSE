package com.zheng.array;

import java.util.Arrays;

public class ArrayDemo06 {
    public static void main(String[] args) {

        int[] a = {1, 2, 3, 5, 9153, 453, 21, 85};

        System.out.println(a);// [I@1b6d3586

        //打印数组元素 Arrays.toString
        System.out.println(Arrays.toString(a));// [1, 2, 3, 5, 9153, 453, 21, 85]

        printArray(a);

        Arrays.sort(a); //数组进行排序：升序

        System.out.println(Arrays.toString(a));// [1, 2, 3, 5, 21, 85, 453, 9153]

        Arrays.fill(a, 0);//数组填充赋值
        System.out.println(Arrays.toString(a));// [0, 0, 0, 0, 0, 0, 0, 0]

        Arrays.fill(a, 2, 4, 2);//填充下标2-4之间的数为2 左闭右开
        System.out.println(Arrays.toString(a));// [0, 0, 2, 2, 0, 0, 0, 0]

    }

    //重复造轮子
    public static void printArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            if (i == 0) {
                System.out.print("[");
            }
            if (i == a.length - 1) {
                System.out.print(a[i] + "]");
            } else {
                System.out.print(a[i] + ", ");
            }
        }
    }
}
