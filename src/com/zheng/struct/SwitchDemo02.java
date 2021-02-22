package com.zheng.struct;

public class SwitchDemo02 {
    public static void main(String[] args) {
        String name = "PePe";
        //JDK7的新特性，表达式结果可以是字符串！！！
        //字符的本质还是数字

        //反编译 Java---class（字节码文件）人看不懂---反编译IEDA（人看的懂）

        switch (name) {
            case "阿昌":
                System.out.println("阿昌");
                break;
            case "PePe":
                System.out.println("PePe");
                break;
            default:
                System.out.println("输入错误");
        }
    }
}
