package com.commonclass.java;


public class Demo02 {
    public static void main(String[] args) {
        String str1 = "abkkcabdkaasdkebfkabkskabds";
        String str2 = "ab";

        int sum = 0;
        char[] charstr1 = str1.toCharArray();
        char[] charstr2 = str2.toCharArray();
        for (int i = 0; i < charstr2.length - 1; i++) {
            for (int j = 0; j < charstr1.length - 1; j++) {
                if (charstr1[j] == charstr2[i]) {
                    if (charstr1[j + 1] == charstr2[i + 1]) {
                        sum = sum + 1;
                    }
                }
            }

        }
        System.out.println(sum);

    }
}
