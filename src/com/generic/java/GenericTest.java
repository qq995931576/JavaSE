package com.generic.java;


import org.junit.Test;
import org.omg.CORBA.INTERNAL;

import java.util.*;

/*
泛型的使用
1. jdk5.0 或1.5 新增的新特性
2. 在集合中使用泛型:
    总结:
        ① 集合接口或集合类在 jdk1.5 时都修改为带泛型的结构。
        ② 在实例化集合类时,可以指明具体的泛型类型
        ③ 指明完以后,在集合类或接口中凡是定义类或接口时,内部结构(比如: 方法、构造器、属性等)使用到类的泛型的位置,都指定为你实例化时的泛型类型
            比如: add(E e) ---> 实例化以后: add(Integer e)
        ④ 注意点: 泛型的类型必须是类, 不能是基本数据类型。若需要用到基本数据类型的位置,拿其包装类替换。
        ⑤ 如果实例化时,没有指明泛型的类型。默认类型为java.lang.Object类型。

3.如何自定义泛型结构: 泛型类、泛型接口; 泛型方法
 */
public class GenericTest {

    //在集合中 不使用泛型 的情况
    @Test
    public void test1() {
        ArrayList list = new ArrayList();
        //需求: 放学生的成绩
        list.add(78);
        list.add(64);
        list.add(90);
        list.add(100);
        //问题一:类型不安全
//        list.add("Tom");

        for (Object score : list) {
            //问题二:强转时,可能出现ClassCastException
            int stuScore = (int) score;
            System.out.println(stuScore);
        }
    }


    //在集合中 使用泛型 的情况：以ArrayList举例
    @Test
    public void test2() {
        ArrayList<Integer> list = new ArrayList<Integer>();

        //jdk7新特性:类型推断
//        ArrayList<Integer> list = new ArrayList();

        list.add(75);
        list.add(89);
        list.add(93);

        //编译时,会进行类型检查,保证数据类型安全
//      list.add("Tom");

        //遍历方式一:
//        for(Integer score:list){
//            int stuScore = score;
//            //避免了强转操作
//            System.out.println(stuScore);
//        }

        //遍历方式二:
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            int stuScore = iterator.next();
            System.out.println(stuScore);
        }
    }

    //在集合中 使用泛型 的情况：以HashMap举例
    @Test
    public void test3() {
        Map<String, Integer> map = new HashMap<String, Integer>();

        map.put("Tom", 87);
        map.put("Jerry", 93);
        map.put("Mike", 76);

//      map.put(123,"ABC");
        //泛型的嵌套
        Set<Map.Entry<String, Integer>> entry = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entry.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry1 = iterator.next();
            Integer value = entry1.getValue();
            String key = entry1.getKey();
            System.out.println("key= " + key + ", value= " + value);
        }
    }
}
