package com.zheng.struct;

import java.util.Scanner;

public class IfDemo02 {
    public static void main(String[] args) {
        //考试分数大于60分及格，小于60分不及格
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入内容");

        int score = scanner.nextInt();
        if (score >= 60) {
            System.out.println("成绩合格");
        } else {
            System.out.println("成绩不合格");
        }

        scanner.close();
    }
}
