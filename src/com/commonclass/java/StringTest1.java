package com.commonclass.java;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class StringTest1 {
    /*
    string 与 byte[]之间的转换
    编码: string -->  byte[]:调用String的getBytes()
    解码:byte[] --> string：调用String的构造器

    编码：字符串 --> 字节 (看得懂 --> 看不懂的    底层二进制数)
    解码：编码的逆过程，字节 --> 字符串 (看不懂的二进制数据 --> 看得动

    说明：解码时，要求解码使用的字符集必须与编码使用的字符集一致，否则会出现乱码。
     */
    @Test
    public void test3() throws UnsupportedEncodingException {
        java.lang.String str1 = "abc123中国";
        byte[] bytes = str1.getBytes();//使用默认(UTF-8)的字符集，进行编码
        System.out.println(Arrays.toString(bytes));//输出ACSII码：[97, 98, 99, 49, 50, 51, -28, -72, -83, -27, -101, -67] 1个中文3个字节

        byte[] gbks = str1.getBytes("gbk");//使用gbk字符集,进行编码
        System.out.println(Arrays.toString(gbks));//[97, 98, 99, 49, 50, 51, -42, -48, -71, -6] 1个中文2个字节

        System.out.println("===========================");

        java.lang.String str2 = new java.lang.String(bytes);//使用String构造器，来用默认的字符集(UTF-8)，进行解码
        System.out.println(str2);//abc123中国

        java.lang.String str3 = new java.lang.String(gbks);//用UTF-8解析gbk解析的gbks
        System.out.println(str3);//abc123�й� 出现乱码。  原因:   编码集和解码集不一致

        String str4 = new String(gbks, "gbk");//指定用gbk字符集来解码
        System.out.println(str4);//abc123中国 没有出现乱码。 原因： 编码集和解码集一致

    }
}




    /*
    string 与 char[]之间的转换

    string -->  char[]:调用String的toCharArray()
    char[] -->  string:调用String的构造器
     */

//   @Test
//    public void test2(){

/*        String str1 = "abc123";
        char[] charArray = str1.toCharArray();//str --> char[]
        for (int i = 0; i < charArray.length; i++) {
            System.out.println(charArray[i]);//输出charArray[]数组中每一个元素
        }

        char[] arr = new char[]{'h','e','l','l','o'};
        String str2 = new String(arr);//char[] -->  string      Ctrl + p 提示
        System.out.println(str2);//hello

    }
*/














    /*
    复习：
        string与基本数据类型、包装类之间的转换

        string --> 基本数据类型、包装类   ：   调用包装类的静态方法 parseXxx(str)
        基本数据类型、包装类 -->string:       调用string重载的valueOf(xxx)

     */

//    @Test
/*    public void test1(){
        String str1 = "123";
//      int num = str1; 错误的，只能通过子父类可转
        int num = Integer.parseInt(str1);//123 string --> 基本数据类型、包装类：       调用包装类的静态方法 parseXxx(str)

        String str2 = String.valueOf(num);//"123" 基本数据类型、包装类 -->string:     调用string重载的valueOf(xxx)
        String str3 = num   +  "";//有变成num参与了都是在堆里

        System.out.println(str1 == str3);//false   str1在方法池   str2在堆里

    }

}
*/