package com.zheng.operator;

public class Demo02 {
    public static void main(String[] args) {
        long a = 12312313213123L;
        int b = 123;
        short c = 10;
        byte d = 8;
        System.out.println(a + b + c + d);  //Long
        System.out.println(b + c + d);  //Int
        System.out.println(c + d);   //Int
        //计算结果自动转行为运算数据中的最高级类型
        // byte>short>char>int>long>float>double 小数优先与数字，数字的数据长度转行为优先
    }
}
