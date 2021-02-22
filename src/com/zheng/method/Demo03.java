package com.zheng.method;

public class Demo03 {
    public static void main(String[] args) {

        int sum = add(1, 4);//实际参数1,2
        System.out.println(sum);
        System.out.println("============================");

    }

    public static int add(int bbb, int aaa) {
        return aaa + bbb;
    }

    public static int add(int aaa, int bbb, int ccc) {
        return aaa + bbb;
    }

    public static double add(double aaa, double bbb) {
        return aaa + bbb;
    }
}
