package com.collection.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

//jdk 5.0 新增了foreach循环，用于遍历集合、数组
public class ForTest {

    @Test
    public void test1() {
        Collection coll = new ArrayList();
        coll.add(1458);
        coll.add(123);
        coll.add(new Person("PePe", 21));
        coll.add(new String("Tom"));

        //for(集合中元素的类型 局部变量 : 集合对象)
        //内部仍然调用了迭代器
        for (Object obj : coll) {
            System.out.println(obj);//1458
            //123
            //Person{name='PePe', age=21}
            //Tom
        }
    }

    @Test
    public void test2() {
        int[] arr = new int[]{1, 2, 348, 5, 8, 94};

        //for(数组中元素的类型 局部变量 : 数组对象)
        for (int i : arr) {
            System.out.println(i);
        }
    }

    //练习题
    @Test
    public void test3() {
        String[] arr = new String[]{"MM", "MM", "MM"};

        //方式一: 普通for赋值
        //修改了原有数组的值arr[i]
        //       for (int i = 0; i < arr.length; i++) {
        //           arr[i] = "GG";
        //       }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);//"GG"
        }

        //方式二: foreach赋值
        //重新建了一个局部变量，讲arr的值赋给s
        //       for (String s : arr){
        //           s ="GG";
        //       }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);//"MM"
        }
    }
}
