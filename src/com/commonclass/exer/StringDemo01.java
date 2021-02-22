package com.commonclass.exer;

import org.junit.Test;

import java.time.Year;

public class StringDemo01 {

    /*
    将一个字符串进行反转。将字符串中指定部分进行反转。比如"abcdefg"反转为"abfedcg"
     */

    //方式一:转换为char[]
    public String reverse1(String str, int startIndex, int endIndex) {

        if (str != null && str.length() != 0) {
            char[] arr = str.toCharArray();
            for (int x = startIndex, y = endIndex; x < y; x++, y--) {
                char temp = arr[x];
                arr[x] = arr[y];
                arr[y] = temp;
            }
            return new String(arr);
        }
        return null;
    }

    //方式二：使用String的拼接方法
    public String reverse2(String str1, int startIndex, int endIndex) {
        if (str1 != null && str1.length() != 0) {
            //第一部分
            String reverseStr = str1.substring(0, startIndex);
            //第二部分
            for (int i = endIndex; i >= startIndex; i--) {
                reverseStr = reverseStr + str1.charAt(i);
            }
            //第三部分
            reverseStr = reverseStr + str1.substring(endIndex + 1);

            return reverseStr;
        }
        return null;
    }

    //方式三：使用StringBuilder/StringBuffer替换String
    public String reverse3(String str1, int startIndex, int endIndex) {
        if (str1 != null && str1.length() != 0) {
            StringBuilder sb1 = new StringBuilder(str1.length());
            //第一部分
            sb1.append(str1.substring(0, startIndex));
            //第二部分
            for (int i = endIndex; i >= startIndex; i--) {
                sb1.append(str1.charAt(i));
            }
            sb1.append(str1.substring(endIndex + 1));

            return sb1.toString();
        }

        return null;
    }

    //方式四:使用StringBuilder/StringBuffer的reverse()方法
    public String reverse4(String str1, int startIndex, int endIndex) {
        if (str1 != null && str1.length() != 0) {
            StringBuilder sb1 = new StringBuilder(str1.length());
            //第一部分
            sb1.append(str1.substring(0, startIndex));
            //第二部分
            String str2 = str1.substring(startIndex, endIndex);
            StringBuffer sb2 = new StringBuffer(str2);
            sb1.append(sb2.reverse());
            //第三部分
            sb1.append(str1.substring(endIndex + 1));
            String sb3 = sb1.toString();
            return sb3;
        }
        return null;
    }


    //方式一测试
    @Test
    public void testReverse1() {
        String str = "abcdefg";
        String reverse = reverse1(str, 2, 5);
        System.out.println(reverse);
    }

    //方式二测试
    @Test
    public void testReverse2() {
        String str = "abcdefg";
        String s = reverse2(str, 1, 5);
        System.out.println(s);
    }

    //方式三测试
    @Test
    public void testReverse3() {
        String str = "abcdefg";
        String str2 = reverse3(str, 1, 5);
        System.out.println(str2);
    }

    //方式四测试
    @Test
    public void testReverse4() {
        String str = "abcdefg";
        String str2 = reverse4(str, 1, 5);
        System.out.println(str2);
    }
}
