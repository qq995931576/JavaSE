package com.commonclass.java;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTimeTest2 {
    /*
    SimpleDateFormat的使用：
        SimpleDateFormat对日期Date类的格式化和解析

    1.两个操作:
        1.1 格式化：日期 --->字符串(Date --->String)

        1.2 解析:格式化的逆过程,字符串 --->日期(String --->Date)

    2.SimpleDateFormat实例化

     */
    @Test
    public void testSimpleDateformat() throws ParseException {//抛出异常:只识别默认格式或设置的有参构造器的格式
        //实例化SimpleDateFormat:使用默认的构造器
        SimpleDateFormat sdf = new SimpleDateFormat();

        //格式化:日期 --->字符串
        Date date = new Date();
        System.out.println(date);//Sat Sep 12 14:25:03 GMT+08:00 2020

        String format = sdf.format(date);//日期 --->字符串
        System.out.println(format);//20-9-12 下午2:26

        //解析:字符串 --->日期
        String str = "20-9-12 下午2:30";
        Date date1 = sdf.parse(str);
        System.out.println(date1);//Sat Sep 12 14:30:00 GMT+08:00 2020

        System.out.println("===============================================");

        //指定方式格式化和解析:调用带参的构造器
        //       SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy.MMMM.dd GGG hh:mm aaa");//构造器指定格式
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");//构造器指定格式
        //格式化
        String format1 = sdf1.format(date);
        System.out.println(format1);//2020-09-12 02:40:34

        //解析:要求字符串必须符合SimpleDateFormat识别的格式(通过有参构造器参数的格式体现)
        //否则，抛异常
        Date date2 = sdf1.parse("2022-09-12 02:40:34");
        System.out.println(date2);//Mon Sep 12 02:40:34 GMT+08:00 2022

    }


    /*
    练习一:字符串"2020-09-08"转换为java.sql.Date
     */
    @Test
    public void testExer() throws ParseException {
        String birth = "2020-09-08";
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf1.parse(birth);
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        System.out.println(sqlDate);//2020-09-08
    }

    /*
    练习二:"三天打鱼两天晒网"  1990-01-01  xxxx-xx-xx 打鱼？晒网？
    举例:2020-09-08?
     */

    @Test
    public void test1exer() throws ParseException {
        String ageTime = "1990-01-01";
        String goalTime = "2020-09-08";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Long ageDate = (sdf.parse(ageTime)).getTime();
        Long goalDate = sdf.parse(goalTime).getTime();
        Long tempDate = ((goalDate - ageDate) / (1000 * 60 * 60 * 24) + 1);
        if (tempDate != 0 && tempDate > 0) {
            if ((tempDate % 5 >= 1) && (tempDate % 5 <= 3)) {
                System.out.println("在打鱼");
            } else {
                System.out.println("在晒网");
            }
        }
    }

    /*
    Calendar日历类(抽象类)的使用

     */
    @Test
    public void testCalendar() {
        //1.实例化
        //方式一: 创建其子类(GregorianCalendar)的对象
        //方式二: 调用其静态方法getInstance()
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getClass());//class java.util.GregorianCalendar，静态方法getInstance()还是由class java.util.GregorianCalendar创建的

        //2.常用方法
        //get()
        int days = calendar.get(Calendar.DAY_OF_MONTH);//生成今天是这个月的第几天
        System.out.println(days);//12            9.12日
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));//256    生成今天是这一年的第几天

        //set()
        calendar.set(Calendar.DAY_OF_MONTH, 22);//更改这个月今年的值为22
        days = calendar.get(Calendar.DAY_OF_MONTH);//Calendar的可变性
        System.out.println(days);//22  就将原本12改成了22

        //add()
        calendar.add(Calendar.DAY_OF_MONTH, 3);
        days = calendar.get(Calendar.DAY_OF_MONTH);//Calendar的可变性
        System.out.println(days);//25   给这个月加了3天

        //getTime() 日历类 --->Date
        Date date = calendar.getTime();
        System.out.println(date);//Fri Sep 25 16:20:06 GMT+08:00 2020

        //setTime() Date --->日历类
        Date date1 = new Date();//date1获取今天的时间
        calendar.setTime(date1);//修改为今天的时间
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);//12  又变回了12号

    }
}
