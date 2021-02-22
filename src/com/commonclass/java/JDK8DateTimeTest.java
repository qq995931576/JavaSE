package com.commonclass.java;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

public class JDK8DateTimeTest {

    /*
    Calendar的问题:
    可变性: 像日期和时间这样的类应该是不可变的(可以通过set()方法来修改时间)
    偏移量: Date总的年份是从1900开始的，而月份都是从0开始的(所以需要减掉)
    格式化: 格式化只对Date有用，Calendar则不行
    此外，他们也不是线程安全的；不能处理闰秒等

     */

    @Test
    public void testDate() {
        //偏移量
        Date date = new Date(2020 - 1900, 9 - 1, 12);
        System.out.println(date);//Sat Sep 12 00:00:00 GMT+08:00 2020
    }


    /*
    LocalDate、LocalTime、LocalDateTime的使用
    说明:
        1.LocalDateTime相较于LocalTime、LocalDate，使用频率更高
        2.类似于Calendar
        3.不可变性
     */

    @Test
    public void test1() {
        //now()：获取当前的日期、时间、日期+时间
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localDate);//2020-09-12
        System.out.println(localTime);//16:59:18.915
        System.out.println(localDateTime);//2020-09-12T16:59:18.915

        //of()： 设置指定的年、月、日、时、分、秒。没有偏移量
        LocalDateTime localDateTime1 = LocalDateTime.of(2020, 9, 12, 17, 03);
        System.out.println(localDateTime1);//2020-09-12T17:03

        //getXxx(): 获取相关的属性
        System.out.println(localDateTime.getDayOfMonth());//12
        System.out.println(localDateTime.getDayOfWeek());//SATURDAY
        System.out.println(localDateTime.getDayOfYear());//256
        System.out.println(localDateTime.getMinute());//8
        System.out.println(localDateTime.getMonthValue());//9 今天是几月

        //withXxx(): 设置相关的属性 体现不可变性
        LocalDate localDate1 = localDate.withDayOfMonth(22);
        System.out.println(localDate);//2020-09-12      本身localDate
        System.out.println(localDate1);//2020-09-22     返回值localDate1

        LocalDateTime localDateTime2 = localDateTime.withHour(14);
        System.out.println(localDateTime);//2020-09-12T17:18:45.925
        System.out.println(localDateTime2);//2020-09-12T14:18:45.925

        //puls()：加
        LocalDateTime localDateTime3 = localDateTime.plusMonths(3);//添加3个月
        System.out.println(localDateTime);//2020-09-12T17:22:10.844
        System.out.println(localDateTime3);//2020-12-12T17:22:10.844

        //minus()：减
        LocalDateTime localDateTime4 = localDateTime.minusDays(6);
        System.out.println(localDateTime);//2020-09-12T17:24:14.341
        System.out.println(localDateTime4);//2020-09-06T17:24:14.341

    }

    /*
Instant类的使用
类似于java.util.Date类
 */
    @Test
    public void test2() {
        //now()： 获取本初子午线对应的当前标准时间
        Instant instant = Instant.now();
        System.out.println(instant);//2020-09-13T09:12:20.306Z  这里采用本初子午线.若是中国时间，需要加上8个小时。

        //atOffset:
        //添加时间的偏移量
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);//2020-09-13T17:17:22.340+08:00     这里在本初子午线时间加上了偏移量8个小时

        //toEpochMilli(): 获取自1970年0时0分0秒到现在对应的毫秒数 ---> Date类的getTime()
        long milli = instant.toEpochMilli();
        System.out.println(milli);//1599988936202

        //ofEpochMilli()： 通给给定的毫秒数，获取Instant实例 ---> Date(long millis)
        Instant ofEpochMilli = Instant.ofEpochMilli(1599988936202L);
        System.out.println(ofEpochMilli);//2020-09-13T09:22:16.202Z
    }


    /*
    DateTimeFormatter:格式化或解析日期、时间
    类似于SimpleDateFormat
    方式一:         预定义的标准格式。如: ISO_LOCAL_DATE_TIME;ISO_LOCAL_DATE;ISO_LOCAL_TIME
    方式二:         本地化相关格式。 如: ofLocalizedDateTime()
    方式三 (重点):  自定义的格式。  如: ofPattern("yyyy-MM-dd hh:mm:ss E")
     */
    @Test
    public void test3() {
//        方式一: 预定义的标准格式。如: ISO_LOCAL_DATE_TIME;ISO_LOCAL_DATE;ISO_LOCAL_TIME
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        //格式化: 日期 --->字符串
        LocalDateTime localDateTime = LocalDateTime.now();
        String str1 = formatter.format(localDateTime);
        System.out.println(localDateTime);//2020-09-13T17:44:27.879
        System.out.println(str1);//2020-09-13T17:44:27.879

        //解析: 字符串 --->日期
        TemporalAccessor parse = formatter.parse(str1);
        System.out.println(parse);//{},ISO resolved to 2020-09-13T17:44:27.879  多态形式

//        方式二:

//        本地化相关格式。 如: ofLocalizedDateTime()
//        FormatSytle.LONG / FormatStyle.MEDIUM / FormatStyle.SHORT ：适用于LocalDateTime
        DateTimeFormatter formatter1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);
        //格式化
        String str2 = formatter1.format(localDateTime);
        System.out.println(str2);//2020年9月13日 下午05时56分09秒
        //解析
        TemporalAccessor parse1 = formatter1.parse(str2);//{},ISO resolved to 2020-09-13T17:57:41
        System.out.println(parse1);

//        本地化相关格式。 如: ofLocalizedDate()
//        FormatSytle.FULL / FormatSytle.LONG / FormatStyle.MEDIUM / FormatStyle.SHORT ：适用于LocalDate
        DateTimeFormatter formatter2 = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        //格式化
        String str3 = formatter2.format(LocalDate.now());
        System.out.println(str3);//2020年9月13日 星期日
        //解析
        TemporalAccessor parse2 = formatter2.parse(str3);
        System.out.println(parse2);//{},ISO resolved to 2020-09-13


//      重点:  方式三: 自定义的格式。  如: ofPattern("yyyy-MM-dd hh:mm:ss E")
        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("yyyy,MM,dd hh:mm:ss");
        //格式化
        String str4 = formatter3.format(LocalDateTime.now());
        System.out.println(str4);//2020,09,13 06:07:44
        //解析
        TemporalAccessor parse3 = formatter3.parse(str4);
        System.out.println(parse3);//{SecondOfMinute=22, HourOfAmPm=6, MicroOfSecond=0, NanoOfSecond=0, MinuteOfHour=8, MilliOfSecond=0},ISO resolved to 2020-09-13

    }
}



