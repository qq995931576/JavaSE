package com.commonclass.java;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.junit.Test;

import java.util.Date;

/*
JDK 8之前日期和时间的API测试

 */
public class DateTimeTest {

    /*
    java.util.Date类
            |---java.sql.Date类|

    1.两个构造器的使用
    构造器一:Date() 创建一个对应当前时间的Date对象
    //构造器二:创建指定毫秒数的Date对象

    2.两个方法的使用
        >toString():显示当前的年、月、日、时、分、秒
        >getTime()：获取当前Date对象对应的毫秒数。(时间戳):返回当前时间 与 1970年1月1日0时0分0秒 以毫秒为单位的时间差

    3.java.sql.Date对应着数据库中的日期类型的变量
        >如何实例化
        >如何将java.util.Date对象转换为java.sql.Date对象

     */
    @Test
    public void test2() {
        //构造器一:Date() 创建一个对应当前时间的Date对象
        Date date1 = new Date();
        System.out.println(date1.toString());//"Wed Sep 09 19:55:09 GMT+08:00 2020"

        System.out.println(date1.getTime());//1599652697049

        //构造器二:创建指定毫秒数的Date对象
        Date date2 = new Date(159965269704L);//毫秒转化为距离1970....的时间
        System.out.println(date2);//Sun Jan 26 18:47:49 GMT+08:00 1975

        //创建java.sql.Date对象
        java.sql.Date date3 = new java.sql.Date(15992697049L);
        System.out.println(date3);//1970-07-05

        //如何将java.util.Date对象转换为javap.sql.Date对象
        //情况一:
        Date date4 = new java.sql.Date(5992697049L);//多态 子类(java.sql.Date)赋给父类(java.util.Dat)
        java.sql.Date date5 = (java.sql.Date) date4;
        //情况二：
        Date date6 = new Date();
//        java.sql.Date date7 = (java.sql.Date)date6;//报错
        java.sql.Date date7 = new java.sql.Date(date6.getTime());//通过util.Date中的getTime方法来获得毫秒数，再转换为sql.Date


    }

    //System类中的currentTimeMillis()
    @Test
    public void test1() {
        long time = System.currentTimeMillis();
        //返回当前时间 与 1970年1月1日0时0分0秒 以毫秒为单位的时间差
        //被称为 ↑时间戳↑
        System.out.println(time);//1599652003079

    }
}
