package com.exception.demo02;

public class Test3 {

    //可能存在异常的方法
    static void test(int a) throws com.exception.demo02.MyException {

        System.out.println("传递的参数为：");
        if (a > 10) {
            throw new com.exception.demo02.MyException(a);//抛出
        }

        System.out.println("OK");
    }

    public static void main(String[] args) {
        try {
            test(11);
        } catch (com.exception.demo02.MyException e) {
            //增加一些处理异常的代码
            System.out.println("MyException=>" + e);
        }
    }
}
