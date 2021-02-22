package com.zheng.array;

public class ArrayDemo03 {
    public static void main(String[] args) {
        int[] arrays = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        //打印全部的数组元素

        for (int i = 0; i < arrays.length; i++) {
            System.out.println(arrays[i]);
        }


        System.out.println("======================");//分割线


        //计算所有元素的和
        int sums = 0;
        for (int i = 0; i < arrays.length; i++) {
            sums += arrays[i];
        }
        System.out.println("sums=" + sums);


        System.out.println("======================");//分割线


        //查找最大元素
        int max = arrays[0];
        for (int i = 1; i < arrays.length; i++) {
            if (arrays[i] > max) {
                max = arrays[i];
            }
        }
        System.out.println("最大数为：" + max);
    }
}
