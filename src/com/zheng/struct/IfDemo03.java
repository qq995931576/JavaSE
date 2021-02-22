package com.zheng.struct;

import java.util.Scanner;

public class IfDemo03 {
    public static void main(String[] args) {
        //考试分数大于60分及格，小于60分不及格
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入内容");

        /*
        if 语句最多有 1 个 else 语句，else 语句的位置在所有 else if 语句之后；
        if 语句可以有若干的 else if 语句，它们必须在 else 语句之前；
        一旦其中一个 else if 语句检测到 true ，其他的 else if 语句都将跳过执行。
         */

        int score = scanner.nextInt();
        if (score >= 60 && score < 80) {
            System.out.println("成绩合格");
        } else if (score == 100) {
            System.out.println("成绩满分");
        } else if (score >= 80 && score < 100) {
            System.out.println("成绩优秀");
        } else if (score < 60) {
            System.out.println("成绩不合格");
        } else {
            System.out.println("成绩不合法");
        }
        scanner.close();
    }
}
