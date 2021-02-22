package com.commonclass.exer;

import org.junit.Test;

public class StringDemo02 {
    /*
    获取一个字符串在另一个字符串中出现的次数
        例如:获取"ab"在"abadsadgaabasdjashdaabasjkdhabb"中出现的次数
     */

    //方式一
    public int getCount1(String mainStr, String subStr) {
        int mainLength = mainStr.length();
        int subLength = subStr.length();
        int index;
        int count = 0;
        if (mainLength > subLength) {
            while ((index = mainStr.indexOf(subStr)) != -1) {
                count++;
                mainStr = mainStr.substring(index + subLength);
            }
            return count;
        } else {
            return 0;
        }
    }

    //方式二
    public int getCount2(String mainStr, String subStr) {
        int mainLength = mainStr.length();
        int subLength = subStr.length();
        int index = 0;
        int count = 0;
        if (mainLength > subLength) {
            while ((index = mainStr.indexOf(subStr, index)) != -1) {
                count++;
                index = index + subLength;
            }
            return count;
        } else {
            return 0;
        }
    }

    //方式一测试
    @Test
    public void testGetCount1() {
        String mainString = "abadsadgaabasdjashdaabasjkdhabb";
        String subString = "ab";
        int count = getCount1(mainString, subString);
        System.out.println(count);
    }

    //方式二测试
    @Test
    public void testGetCount2() {
        String mainString = "abadsadgaabasdjashdaabasjkdhabb";
        String subString = "ab";
        int count = getCount2(mainString, subString);
        System.out.println(count);
    }
}
