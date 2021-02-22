package com.zheng.array;

public class ArrayDemo04 {
    public static void main(String[] args) {
        int[] arrays = {1, 2, 3, 4, 5};

        //JDK1.5，没有下标 适合打印输出
        //     每一个值     数组
        for (int array : arrays) {
            System.out.println(array);
        }
        printArray(arrays);
        int[] reverse = reverse(arrays);

        printArray(reverse);
    }

    //打印数组元素
    public static void printArray(int[] arrays) {
        for (int i = 0; i < arrays.length; i++) {
            System.out.print(arrays[i] + " ");
        }
    }

    //反转数组
    public static int[] reverse(int[] arrays) {
        int[] result = new int[arrays.length];

        //反转操作
        for (int i = 0, k = result.length - 1; i < arrays.length; i++, k--) {
            result[k] = arrays[i];
        }
        return result;
    }
}
