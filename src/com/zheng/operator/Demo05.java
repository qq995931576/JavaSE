package com.zheng.operator;

//逻辑运算符
public class Demo05 {
    public static void main(String[] args) {
        //与（and）&&  或（or）||   非（取反）!
        boolean a = true;
        boolean b = false;

        System.out.println("a && b:" + (a && b));//逻辑与运算：两个变量都为真，结果才能为True
        System.out.println("a || b:" + (a || b));//逻辑或运算：两个变量有一个为真，则结果就为True
        System.out.println("!(a && b):" + !(a && b));//如果是真，则变为假。如果为假，则为真

        //短路运算
        int c = 5;
        boolean d = (c < 4) && (c++ < 4);
        System.out.println(c);
        System.out.println(d);
    }
}
