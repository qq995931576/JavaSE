package com.zheng.array;

import java.util.Arrays;

public class ArrayDemo07 {
    public static void main(String[] args) {

        int[] a = {1, 8, 6, 7, 25, 36, 55, 14, 86, 27, 96};

        int[] sort = sort(a);//调用自定义的排序方法后，返回一个排序后的数组
        System.out.println(Arrays.toString(sort));

    }


    //冒牌排序
    //1.比较数组中，两个相邻的元素，如果第一个数比第二个数大，我们就交换他们的位置
    //2.每一次比较，都会产生出一个最大，或者最小的数字；
    //3.下一轮，则就可以少一次排序！
    //4.依次循环，知道结束！

    public static int[] sort(int[] array) {

        //临时变量
        int temp = 0;

        //外层循环，判断我们这个要走多少次；
        for (int i = 0; i < array.length - 1; i++) {
            //内层循环，比较判断两个数组元素大小，如果第一个数，比第二个数大，则交换位置。
            for (int j = 0; j < array.length - 1 - i; j++) {
                boolean flag = false;//通过flag的标识位减少没意义的比较

                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    flag = true;
                }
                if (flag = false) {
                    break;
                }
            }
        }
        return array;
    }
}
