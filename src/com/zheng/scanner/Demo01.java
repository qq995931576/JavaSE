package com.zheng.scanner;

import java.util.Scanner;

public class Demo01 {
    public static void main(String[] args) {

        //创建一个扫描器（Scanner）对象，用于接受键盘的数据
        Scanner scanner = new Scanner(System.in);

        System.out.println("使用Next方式接受：");

        //判断用户有没有输入字符串
        if (scanner.hasNext() == true) {
            //使用Next方式接受
            String str = scanner.next();//程序会等待用户输入完毕
            System.out.println("输出的内容为：" + str);

        }
        //凡是属于IO流的类如果不关闭就会一直占用资源，用完及时关闭 养成良好习惯
        scanner.close();
    }
}
