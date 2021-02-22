package com.zheng.scanner;

import java.util.Scanner;

public class Demo05 {
    public static void main(String[] args) {
        ////我们可以输入多个数字，并求其求和与平均数，每输入一个数字用回车确认，通过输入非数字来结束输入并输出执行结果：

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你的数据：");

        int m = 0;
        double sum = 0;
        while (scanner.hasNextDouble()) {
            double x = scanner.nextDouble();
            sum = sum + x;
            m = m + 1;
            System.out.println("你当前一共输入了" + m + "个数据，且求和为Sum=" + sum);

        }
        scanner.close();
        System.out.println("你当前一共输入了" + m + "个数据，且求和为Sum=" + sum);
        System.out.println("你当前一共输入了" + m + "个数据，且平均数为" + (sum / m));
    }
}

