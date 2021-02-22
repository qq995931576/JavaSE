package com.zheng.array;

public class ArrayDemo05 {
    public static void main(String[] args) {


        //[4][2]
        /*
            1,2     array[0]
            2,3     array[1]
            3,4     array[2]
            4,5     array[3]
         */
        int[][] array = {{1, 2}, {2, 3}, {3, 4}, {4, 5}};
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.println(array[i][j]);

            }
        }
    }

    //打印数组元素
    public static void printArray(int[] arrays) {
        for (int i = 0; i < arrays.length; i++) {
            System.out.print(arrays[i] + " ");
        }
    }
}
