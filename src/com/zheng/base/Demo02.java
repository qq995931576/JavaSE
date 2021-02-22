package com.zheng.base;

public class Demo02 {
    public static void main(String[] args) {
        //整数扩展： 进制       二进制0b   十进制   八进制0   十六进制0x

        int i = 10;
        int i2 = 0b10;  //二进制0b
        int i3 = 010;   //八进制0
        int i4 = 0x10;  //十六进制0x      0-9 A-F 16
        System.out.println(i);
        System.out.println(i2);
        System.out.println(i3);
        System.out.println(i4);
        System.out.println("====================================");
        //===============================
        //浮点数拓展  银行业务怎么表示？   钱
        //BigDecimal 数字工具类
        //===============================
        //float 有限  离散  摄入误差  大约  接近但不等于
        //double
        //最好避免使用浮点数进行比较
        // 最好避免使用浮点数进行比较
        //最好避免使用浮点数进行比较
        float f = 0.1F; //0.1
        double d = 0.1; //0.1

        System.out.println(f == d); //false

        float f1 = 1231321321321321321F;
        float f2 = f1 + 1;
        System.out.println(f2 == f1);//true

        //===============================
        //字符拓展
        //===============================
        System.out.println("====================");
        char z1 = 'a';
        char z2 = '昌';
        System.out.println(z1);
        System.out.println((int) z1);  //强制转行
        System.out.println(z2);
        System.out.println((int) z2);  //强制转行
        //所有的字符本质还是数字
        //编码  Unicode 表：91=a  65=A  2字节  0 - 65536   Excel   2^16=65536

        //U000 UFFF
        char z3 = '\u0065';// 内部优尼科（Unicode）代码
        System.out.println(z3);//e

        //转义字符
        // \t 制表符
        // \n 换行
        System.out.println("com.zheng.Base.Hello\tWorld");
        System.out.println("=====================");

        System.out.println("com.zheng.Base.Hello\rWorld");
        System.out.println("=====================");

        //布尔值扩展
        boolean flag = true;
        if (flag == true) {
        } //新手
        if (flag) {
        }     //老手
        //Less is more   代码要精简易读

    }
}