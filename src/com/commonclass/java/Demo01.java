package com.commonclass.java;

import com.sun.org.apache.xpath.internal.operations.String;
import org.junit.Test;


public class Demo01 {

    @Test
    public void test1() {
        java.lang.String s = "   温州大张伟    ";
        java.lang.String str = new java.lang.String();
        str = myTrim(s);
        System.out.println(str);

    }

    //去掉字符串两端空格
    public static java.lang.String myTrim(java.lang.String str) {
        int start = 0;
        int end = str.length() - 1;

        while (end >= start && str.charAt(start) == ' ')
            start++;
        while (end >= start && str.charAt(end) == ' ')
            end--;
        return str.substring(start, end + 1);

    }


}
