package com.commonclass.java;

import org.junit.Test;

public class StringMethodTest {

    /*

    替换:
    String replace(char oldChar,char newChar)：返回一个新的字符串，它是通过用newChar替换此字符串中出现的所有oldChar得到的。
    String replace(CharSequence target,CharSequence replacement)：使用指定的字面值替换序列替换此再出发所有匹配字面值目标序列的子字符串
    String replaceAll(String regex,String replacement)：使用给定的replacement替换此字符串所有匹配给定的正则表达式的字符串。
    String replaceFirst(String regex,String replacement)：使用给定的replacement替换此字符串匹配给定的正则表达式的第一个子字符串。

    匹配:
    boolean matches(String regex):告知此字符串是否匹配给定的正则表达式。

    切片：
    String[] split(String regex)：根据给定正则表达式的匹配拆分此字符串
    String[] split(String regex,int limit):根据匹配给定的正则表达来拆分此字符串，最多不超过limit个，如果超过了，剩下的全部都放到最后一个元素中。

     */

    @Test
    public void test4() {
        String str1 = "浙江温州阿昌再此";
        String str2 = str1.replace('昌', '郑');//替换所有'昌'为'郑'一个字符
        System.out.println(str1);//浙江温州阿昌再此     String的不可变性
        System.out.println(str2);//浙江温州阿郑再此

        String str3 = str1.replace("再此", "前来报道");//替换所有"再此"为"前来报道"多个字符串
        System.out.println(str1);//浙江温州阿昌再此     String的不可变性
        System.out.println(str3);//浙江温州阿昌前来报道

        System.out.println("=======================");

        String str = "1314hello432world561java2391mysql23219";
        //把字符串中的数字替换成 "，"和如果结果中开头有","的话去掉
        String string = str.replaceAll("\\d+", ",").replaceAll("^,|,$", "");
        System.out.println(string);//hello,world,java,mysql

        String str01 = "12345";
        //判断str01字符串中是否全部有数字组成，即有1-n个数字组成
        boolean matches = str01.matches("\\d+");//判断是否全是数字
        System.out.println(matches);//true
        String tel = "0571-4534289";
        //判断这是否是一个杭州的固定号码
        boolean result = tel.matches("0571-\\d{7,8}");//判断区号是否为0571且后面为7位或8位的数字
        System.out.println(result);//true

        System.out.println("================================");

        String str02 = "hello|world|java";
        String[] strs02 = str02.split("\\|");// 通过“|”来切片拆分
        for (int i = 0; i < strs02.length; i++) {
            System.out.println(strs02[i]);
        }

        System.out.println();

        String str03 = "hello.world.java";
        String[] strs03 = str03.split("\\.");// 通过“，”来切片拆分
        for (int i = 0; i < strs03.length; i++) {
            System.out.println(strs03[i]);
        }
    }

















    /*
    boolean endsWith(String suffix):测试此字符串是否以指定的后缀结束
    boolean startsWith(String prefix):测试此字符串是否以指定的前缀结束
    boolean startsWith(String prefix,int toffset):测试此字符串从指定索引开始的子字符串是否以指定前缀开始

    boolean contains(CharSequence s):当且仅当此字符串包含指定的char值序列时，返回true
    int indexOf(String str)：返回指定子字符串在此字符串中第一次出现处的索引
    int indexOf(String str,int fromIndex)：返回指定子字符串在此字符串中第一次出现处的索引，从指定的索引开始。
    int lastIndexOf(String str):返回指定子字符串在此字符串中最右边出现处的索引
    int lastIndexOf(String str,int fromIndex):返回指定子字符串在此字符串中最后一次出现处的索引，从指定的索引开始反向搜索
    注：indexOf和lastIndexOf方法如果未找到都是返回-1
     */


    @Test
    public void test3() {
        String str1 = "helloworld";
        boolean b1 = str1.endsWith("ld");//结尾是否是ld？
        System.out.println(b1);//true

        boolean b2 = str1.startsWith("he");//前缀是否是he？
        System.out.println(b2);//true

        boolean b3 = str1.startsWith("ll", 2);//从st1[2]开始是否是ll开头？
        System.out.println(b3);//true

        String str2 = "wo";
        System.out.println(str1.contains(str2));//true   str1是否包含str2?

        System.out.println(str1.indexOf("lo"));//3  首次出现的位置  若没有则为-1

        System.out.println(str1.indexOf("lo", 5));//false   找"lo“,从str1[5]开始找

        String str3 = "helloworld";
        System.out.println(str3.lastIndexOf("or"));//6 在str1中从后往前找"or"第一次出现的索引位置，返回的索引是从前往后的索引
        System.out.println(str3.lastIndexOf("o", 5));//4 从左往右数第5个索引，向左找"o"，第一个出现位置的索引为4

        //什么情况下，indexOf(str)和lastIndexOf(str)返回值相同？
        //情况一：存在唯一的str(数据就1字节)   情况二：不存在str
    }


    /*
    int length():返回字符串的长度： return value.length
    char charAt(int index):返回某索引处的字符return value[index]
    boolean isEmpty()：判断是否是空字符串：return value.length == 0
    String toLowerCase():使用默认语言环境，将String中的所有字符转行为小写
    String toUpperCase():使用默认语言环境，将String中的所有字符转行为大写
    String trim():返回字符串的副本，忽略前导空白和尾部空白
    boolean equals(Object obj)：比较字符串的内容是否相同
    boolean equalsIgnoreCase(String anotherString):与equals方法类似，忽略大小写
    String concat(String str)：将指定字符串连接到此字符串的结尾。 等价于用“+”
    int compareTo(String anotherString):比较两个字符串的大小
    String substring(int beginIndex):返回一个新的字符串，它是此字符串的从beginIndex开始截取到最后一个字符串。
    String substring(int beginIndex,int endIndex):返回一个新的字符串，它是此字符串的从beginIndex开始截取到endIndex(不包含)的字符串    [beginIndex,endIndex)左闭右开




     */
    @Test
    public void test2() {
        String s1 = "HelloWorld";
        String s2 = "helloworld";
        System.out.println(s1.equals(s2));//false 不忽略大小写比较
        System.out.println(s1.equalsIgnoreCase(s2));//true  忽略大小写比较

        String s3 = "abc";
        String s4 = s3.concat("def");
        System.out.println(s4);//abcdef

        String s5 = "abc";
        String s6 = new String("abe");
        System.out.println(s5.compareTo(s6));//-2   c(ASCII:99)-e(ASCII：101)=-2 涉及到字符串排序

        String s7 = "浙江温州Oni pepe";
        String s8 = s7.substring(4);
        System.out.println(s7);
        System.out.println(s8);

        String s9 = s7.substring(2, 4);//左闭右开
        System.out.println(s9);//温州

    }


    @Test
    public void test1() {
        String s1 = "HelloWorld";
        System.out.println(s1.length());//10

        System.out.println(s1.charAt(3));//l

        System.out.println(s1.isEmpty());//flase

        String s2 = s1.toLowerCase();
        System.out.println(s1);//HelloWorld  s1不可变的，任然为原来的字符串，不要就拿着s1去操作了
        System.out.println(s2);//helloworld 改成小写以后的字符串

        String s3 = "        h e ll o wor ld       ";
        String s4 = s3.trim();
        System.out.println("---" + s3 + "---");//---        h e ll o wor ld       ---
        System.out.println("---" + s4 + "---");//---h e ll o wor ld---  去除掉首部和尾部的空格

    }
}
