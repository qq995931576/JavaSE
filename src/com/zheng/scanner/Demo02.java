package com.zheng.scanner;

import java.util.Scanner;

public class Demo02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //用键盘接受数据
        System.out.println("使用nextline方式接受：");

        //判断是否还有输入
        if (scanner.hasNextLine()) {
            String str = scanner.nextLine();
            System.out.println("输出的内容为：" + str);

        }

        scanner.close();

    }
}
