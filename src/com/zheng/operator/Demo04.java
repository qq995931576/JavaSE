package com.zheng.operator;

public class Demo04 {
    public static void main(String[] args) {
        //++   --    自增，自减  一元运算符
        int a = 3;

        int b = a++;  //执行完这行代码后，先给b赋值，再自增
        //a = a + 1；
        System.out.println(b);
        //a = a + 1
        int c = ++a;  //执行完这行代码前，先自增，再赋值
        System.out.println("____________________________");
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);

        //幂运算 2^3   2*2*2=8
        Double pow = Math.pow(2, 3);
        System.out.println(pow);

    }
}
