package com.iostream.java;

import com.sun.org.apache.bcel.internal.generic.NEW;
import org.junit.Test;

import java.io.*;

/*
处理流之二: 转换流的使用
    1. 转换流: 属于字符流(看后缀)
        InputStreamReader: 将一个字节的输入流转换为字符的输入流
        OutputStreamWriter: 将一个字符的输出流转换为字节的输出流

    2. 作用: 提供字节流与字符流之间的转换

    3. 解码: 字节、字节数组  --->字符数组、字符串
       编码: 字符数组、字符串  --->字节、字节数组

    4. 字符集
    -ASCII：美国标准信息交换码。   用一个字节的7位可以表示。
    -ISO8859-1：拉丁码表。欧洲码表  用一个字节的8位表示。
    -GB2312：中国的中文编码表。最多两个字节编码所有字符
    -GBK：中国的中文编码表升级，融合了更多的中文文字符号。最多两个字节编码
    -Unicode：国际标准码，融合了目前人类使用的所有字符。为每个字符分配唯一的 字符码。所有的文字都用两个字节来表示。
    -UTF-8：变长的编码方式，可用1-4个字节来表示一个字符


 */
public class InputStreamReader {
    //InputStreamReader的使用,实现将字节输入流转字符输入流转换
    @Test
    public void test1() {
        java.io.InputStreamReader isr = null;//指明具体使用哪个字符集,其取决于文件消息信息.txt他保存时使用的字符集
        try {
            FileInputStream fis = new FileInputStream("消息信息.txt");
//        java.io.InputStreamReader isr = new java.io.InputStreamReader(fis);//使用系统默认的字符集
            isr = new java.io.InputStreamReader(fis, "UTF-8");

            char[] cubf = new char[20];
            int len;
            while ((len = isr.read(cubf)) != -1) {
                String str = new String(cubf, 0, len);
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (isr != null) {
                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //将消息信息.txt从字符集UTF-8转换为GBK字符集,使用转换流实现文件的读入和写出转换
    @Test
    public void test2() {
        java.io.InputStreamReader isr = null;
        OutputStreamWriter osw = null;
        try {
            FileInputStream fis = new FileInputStream("消息信息.txt");
            FileOutputStream fos = new FileOutputStream("消息信息_gbk.txt");

            isr = new java.io.InputStreamReader(fis, "UTF-8");
            osw = new OutputStreamWriter(fos, "GBK");

            char[] cubf = new char[20];
            int len;
            while ((len = isr.read(cubf)) != -1) {
                osw.write(cubf, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (osw != null) {
                try {
                    osw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (isr != null) {
                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
