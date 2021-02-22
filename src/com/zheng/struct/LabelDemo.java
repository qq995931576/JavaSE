package com.zheng.struct;

public class LabelDemo {
    public static void main(String[] args) {
        //打印101-150之间所有的质数
        //质数：指在大于1的自然数中，除了1和它本身以外不能有其他因数的自然数。

        //不建议使用！！！
        outer:
        for (int i = 101; i < 150; i++) {
            for (int j = 2; j < i / 2; j++) {
                if (i % j == 0) {
                    continue outer;
                }
            }
            System.out.print(i + " ");
        }
    }
}
