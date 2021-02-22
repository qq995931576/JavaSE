package com.zheng.struct;

public class ForDemo06 {
    public static void main(String[] args) {
        int[] number = {10, 20, 30, 40, 50}; //定义一个数组

        for (int i = 0; i < 5; i++) {
            System.out.println(number[i]);//for语句原方法
        }
        System.out.println("============================");
        //遍历数组的元素
        for (int x : number) {
            System.out.println(x);//增强for语句方法
        }
    }
}
