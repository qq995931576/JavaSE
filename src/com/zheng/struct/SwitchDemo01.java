package com.zheng.struct;

public class SwitchDemo01 {
    public static void main(String[] args) {
        //case穿透 //switch 匹配一个具体的值
        char grade = 'C';

        switch (grade = 'A') {
            case 'A':
                System.out.println("优秀");
                break;//可选 强制结束
            case 'B':
                System.out.println("良好");
                break;//可选 强制结束
            case 'C':
                System.out.println("合格");
                break;//可选 强制结束
            case 'D':
                System.out.println("再接再厉");
                break;//可选 强制结束
            case 'E':
                System.out.println("挂科");
                break;//可选 强制结束
            default:
                System.out.println("输入错误");
                break;//可选 强制结束
        }
    }
}
