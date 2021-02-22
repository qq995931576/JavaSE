package com.zheng.method;

import java.util.Scanner;

//使用switch实现简易的计算器（实现加减乘除)
public class Demo07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你的整数表达式（例如:2+6):");
        int a = scanner.nextInt();
        char Symbol = scanner.next().charAt(0);
        int b = scanner.nextInt();

        switch (Symbol) {
            case '+':
                add(a, b);
                ;
                break;
            case '-':
                subtract(a, b);
                ;
                break;
            case '*':
                ride(a, b);
                ;
                break;
            case '/':
                except(a, b);
                ;
                break;
            default:
                System.out.println("输入错误");
                break;

        }
        scanner.close();
    }


    public static void add(int a, int b) {
        int numbers = a + b;
        System.out.println(numbers);
        ;
    }

    public static void subtract(int a, int b) {
        int numbers = a - b;
        System.out.println(numbers);
    }

    public static void ride(int a, int b) {
        int numbers = a * b;
        System.out.println(numbers);
    }

    public static void except(int a, int b) {
        int numbers = a / b;
        if (b == 0) {
            System.out.println("除数不能为0");
        }
        System.out.println(numbers);
    }
}