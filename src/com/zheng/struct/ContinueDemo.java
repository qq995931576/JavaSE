package com.zheng.struct;

public class ContinueDemo {
    public static void main(String[] args) {

        int i = 0;
        while (i < 30) {
            i++;
            if (i >= 25 & i <= 28) { //利用continue 跳过25-28
                continue;
            }
            System.out.println(i);//输出1-30除25-28意外的值
        }
        //break在任何循环语句的主体部分，均可用break控制循环的流程--------------------break=辞职
        //break用于强行退出循环，不执行循环中剩余的语句。（break语句也在switch语句中使用）

        //continue语句用在循环语句体重，用于终止某次循环过程，即跳过循环体中未尚执行的语句，接着进行下一次是否执行循环的判断--continue=调休

    }
}

