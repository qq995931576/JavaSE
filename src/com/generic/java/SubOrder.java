package com.generic.java;

public class SubOrder extends Order<Integer> {//SubOrder: 不是泛型类
}
//实例化时,如下代码错误:
//SubOrder<Integer> o = new SubOrder<>();