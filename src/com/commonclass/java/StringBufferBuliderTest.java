package com.commonclass.java;

import org.junit.Test;

public class StringBufferBuliderTest {
    //StringBuffer、StringBulider的常用方法
    /*
    StringBuffer append(xxx):提供了许多append()方法，用于进行字符串拼接
    StringBuffer delete(int start,int end):删除指定位置的内容 左闭右开
    StringBuffer replace(int start,int end,String str):把[start,end）位置替换为str  左闭右开
    StringBuffer insert(int offset,xxx):在指定位置插入xxx
    StringBuffer reverse():把当前字符串序列逆转
    public int indexOf(String str):返回一个str字符串在索引位置
    public String substring(int start,int end):返回一个从start开始到end结束的索引地址，左闭右开区间，的子字符串
    public int length():返回一个字符串长度的值
    public char charAt(int n):返回一个n索引位置的字符
    public void setCharAt(int n,char ch):将指定的字符，改成新的ch字符

    总结:
        增: append(xxx)
        删: delete(int start,int end)
        改: public void setCharAt(int n,char ch) / StringBuffer replace(int start,int end,String str)
        查: charAt(int n)
        插: insert(int offset,xxx)
        长度: length()
        遍历: for() + charAt() / toString()

    */

    @Test
    public void test2() {
        StringBuffer s1 = new StringBuffer("abc");
        s1.append(1);
        s1.append('1');
        System.out.println(s1);//abc11

//        s1.delete(2,4);
//       System.out.println(s1);//ab11

//        s1.replace(1,3,"hi");
//        System.out.println(s1);//ahi11

//        s1.insert(2,9980);
//        System.out.println(s1);//ab9980c11 插入c的位置，所以c还在

//        s1.reverse();
//        System.out.println(s1);//11cba

//        int temp = s1.indexOf("b");
//        System.out.println(temp);//1 "b"首次出现在s1的索引位置

//        String array1 = s1.substring(0, 3);
//        System.out.println(array1);//abc

//        int sblength = s1.length();
//        System.out.println(sblength);//5

//        char a = s1.charAt(3);
//        System.out.println(a);//"1"

//        s1.setCharAt(2,'o');
//        System.out.println(s1);//abo11

    }











    /*
    String、StringBuffer、StringBulider三者的异同

    String:不可变的字符序列；JDK1.0；底层使用char[]存储

    StringBuffer:可变的字符序列；JDK1.0；(buffer:缓冲、缓存、缓冲区、缓冲物)；线程安全，效率低；底层使用char[]存储

    StringBuilder:可变的字符序列；JDK1.5；线程不安全，效率高；底层使用char[]存储

    底层源码分析:
    String str = new String();//实际上new char[0];
    String str = new String("abc");//实际上new char[]{'a','b','c'}

    StringBuffer sb1 = new StringBuf();//char[] value = new char[15];底层创建了一个长度是16的数组
    System.out.println(sb1.length());//0
    sb1.append('a'); //在sb1中添加一个'a';    value[0] = 'a';
    sb1.append('b'); //在sb1中添加一个'b';    value[1] = 'b';

    StringBuffer sb2 = new StringBuffer("abc");//char[] value = new char["abc".length() + 16];

    //问题
        1.  System.out.println(sb2.length());//3
        2.  扩容问题:如果要添加的数据底层数组盛不下了，那就需要扩容底层的数组。
                    默认情况下，扩容为原来容量的2倍 + 2，同时将原有数组中的元素复制到新的数组中。

            指导意义： 开发中建议大家使用：StringBuffer(int capacity) 或 StringBuilder(int capacity)

     */

    @Test
    public void test1() {
        StringBuffer sb1 = new StringBuffer("abc");
        sb1.setCharAt(0, 'm');//将sb1[0]改成'm'
        System.out.println(sb1);//mbc;可变性;没有返回值

        StringBuffer sb2 = new StringBuffer();
        System.out.println(sb2.length());//0

    }
}
