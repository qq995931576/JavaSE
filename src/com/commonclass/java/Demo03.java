package com.commonclass.java;

import javax.print.DocFlavor;
import java.util.Arrays;

public class Demo03 {

    public static void main(String[] args) {
        String str = "AASLKJHGFXDSFDSHFSLAGBNXV";
        sort(str);

    }

    //对字符串进行自然顺序排序
    public static String sort(String str1) {
        char[] charArray = str1.toCharArray();//字符串变成字符数组
        Arrays.sort(charArray);//排序
        String str2 = new String(charArray);//将排序后的数组变成字符串
        System.out.println(str2);
        return str2;
    }
}
