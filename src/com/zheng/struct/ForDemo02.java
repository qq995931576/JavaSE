package com.zheng.struct;

public class ForDemo02 {
    public static void main(String[] args) {
        //练习1：计算0-100之间的奇数和偶数的和
        int oddsum = 0;
        int evensum = 0;
        for (int i = 0; i <= 100; i++) {
            if (i % 2 != 0) {//奇数
                oddsum += i;//oddsum=oddsum +i
            } else {//偶数
                evensum += i;//evensum=evensum +i
            }
        }
        System.out.println("奇数的和为：" + oddsum);
        System.out.println("偶数的和为：" + evensum);
        System.out.println("奇数与偶数的和为：" + (oddsum + evensum));

    }
}
