package com.zheng.scanner;

import java.util.Scanner;

public class Demo03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //从接盘接受数据
        int i = 0;
        float f = 0.0f;

        System.out.println("请输出整数:");

        //如果...那么...
        if (scanner.hasNextInt()) {
            i = scanner.nextInt();
            System.out.println("整数数据：" + i);

        } else {
            System.out.println("你输入的不是整数数据！");
        }

        System.out.println("请输出整数:");

        //如果...那么...
        if (scanner.hasNextFloat()) {
            f = scanner.nextFloat();
            System.out.println("请输入小数：" + f);

        } else {
            System.out.println("你输入的不是小数数据！");
        }


        scanner.close();
    }
}
