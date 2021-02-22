package com.commonclass.java;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

/*
其他常用类的使用
1.System类
2.Math类
3.BigInteger类 和 BigDecimal类
 */
public class OtherClassTest {

    //System类
    @Test
    public void test1() {

        String javaVersion = System.getProperty("java.version");
        System.out.println("java.version：" + javaVersion);//java.version：1.8.0_261

        String javaHome = System.getProperty("java.home");
        System.out.println("java.home：" + javaHome);//java.home：D:\Environment\Java\JDK1.8\jre

        String osName = System.getProperty("os.name");
        System.out.println("os.name：" + osName);//os.name：Windows 10

        String osVersion = System.getProperty("os.version");
        System.out.println("os.version:" + osVersion);//os.version:10.0

        String userName = System.getProperty("user.name");
        System.out.println("user.name:" + userName);//user.name:PePe

        String userHome = System.getProperty("user.home");
        System.out.println("user.home:" + userHome);//user.home:C:\Users\PePe

        String userDir = System.getProperty("user.dir");
        System.out.println("user.dir:" + userDir);//user.dir:D:\Note
    }

    //BigInteger类 与 BigDecimal类 支持任意精度
    @Test
    public void test2() {
        BigInteger bi = new BigInteger("1243365165132194565161241123");
        BigDecimal bd = new BigDecimal("12435.351");
        BigDecimal bd2 = new BigDecimal("11");
        System.out.println(bi);//1243365165132194565161241123
        //System.out.println(bd.divide(bd2));
        System.out.println(bd.divide(bd2, BigDecimal.ROUND_HALF_UP));//1130.486 四舍五入
        System.out.println(bd.divide(bd2, 15, BigDecimal.ROUND_HALF_UP));//1130.486454545454545          保留15位小数
    }
}
