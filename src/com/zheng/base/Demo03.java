package com.zheng.base;

public class Demo03 {
    public static void main(String[] args) {
        int i = 128; //byte -128~128
        byte b = (byte) i; //内存溢出

        //强制转行   (类型)变量名     高--低
        //自动转行     低--高

        System.out.println(i);
        System.out.println(b);

        /*
        注意点：
        1.不能对布尔值转换
        2.不能把对象类型转换为不相干的类型
        3.把高容量转换到低容量的时候，强制转行
        4.转换时可能会出现精度问题或者内存溢出！
         */
        System.out.println((int) 12.3);//12
        System.out.println((int) -45.69F);//-45
        System.out.println("========================");
        char c = 'a';
        int d = c + 1;
        System.out.println(d);
        System.out.println((char) d);

    }
}
