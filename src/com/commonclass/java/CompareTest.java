package com.commonclass.java;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/*
    一.说明: Java中的对象，正常情况下，只能进行比较: == 或 != 。不能使用 > 或 < 的
            但是在开发场景中，我们需要对多个对象进行排序，言外之意，就需要比较对象的大小。
            如何实现呢?-----使用两个接口中的任意一个: Comparable 或 Comparator

    二.Comparable接口的使用

 */
public class CompareTest {
    /*
    Comparable接口的使用举例:  自然排序    调形参obj和方法this对象比较
        1. 像String、包装类等实现了Comparable接口，重写了CompareTo(obj)方法，给出了比较两个对象大小的方式
        2. 像String、包装类重写compareTo()方法以后，进行了从小到大的排列
        3. 重写compareTo(obj)方法的规则:
            如果当前对象this大于形参对象obj，则返回正整数；
            如果当前对象this小于形参对象obj，则返回负整数；
            如果当前对象this等于形参对象obj，则返回零。
        4. 对于自定义类来说，如果需要排序，我们可以让自定义类实现Comparable接口，重写compareTo(obj)方法
            在compareTo(obj)方法中，指明如何排序

     */
    @Test
    public void test1() {
        String[] arr = new String[]{"AA", "JJ", "CC", "GG", "KK", "MM"};

        Arrays.sort(arr);//整理

        System.out.println(Arrays.toString(arr));//[AA, CC, GG, JJ, KK, MM]

    }

    @Test
    public void test2() {
        Goods[] arr = new Goods[5];
        arr[0] = new Goods("lenovomouse", 35);
        arr[1] = new Goods("xiaomimouse", 12);
        arr[2] = new Goods("dellmouse", 56);
        arr[3] = new Goods("huaweimouse", 79);
        arr[4] = new Goods("microsoftmouse", 56);

        Arrays.sort(arr);

        System.out.println(Arrays.toString(arr));//[Goods{name='xiaomimouse', price=12.0}, Goods{name='lenovomouse', price=35.0}, Goods{name='dellmouse', price=56.0}, Goods{name='microsoftmouse', price=56.0}, Goods{name='huaweimouse', price=79.0}]

    }

    /*
    Comparator接口的使用: 定制排序   调形参o1与形参o2之间比较
    1. 背景:
        当元素的类型没有实现java.util.Comparable接口而又不方便修改代码，
        或者实现了java.lang.Comparable接口的排序规则不适合当前的操作，
        那么可以考虑使用Comparator的对象来排序
    2. 重写compare(Object o1,Object o2)方法，比较o1和o2的大小:
        如果方法返回正整数，则表示o1大于o2；
        如果方法返回负整数，则表示o1小于o2；
        如果方法返回零，则表示o1等于o2；

     */

    @Test
    public void test3() {
        String[] arr = new String[]{"AA", "JJ", "CC", "GG", "KK", "MM"};
        Arrays.sort(arr, new Comparator<Object>() {
            //按照字符串从大到小顺序排列
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof String && o1 instanceof String) {
                    String s1 = (String) o1;
                    String s2 = (String) o2;
                    return -s1.compareTo(s2);
                }
                throw new RuntimeException("输入不符合要求");
            }
        });

        System.out.println(Arrays.toString(arr));//[MM, KK, JJ, GG, CC, AA]
    }

    @Test
    public void test4() {
        Goods[] arr = new Goods[6];
        arr[0] = new Goods("lenovomouse", 35);
        arr[1] = new Goods("xiaomimouse", 12);
        arr[2] = new Goods("dellmouse", 56);
        arr[3] = new Goods("huaweimouse", 79);
        arr[4] = new Goods("microsoftmouse", 56);
        arr[5] = new Goods("microsoftmouse", 90);
        Arrays.sort(arr, new Comparator() {
            //    //自定义排序，按照什么方式进行排序，如按照商品名字从低到高排序,再按照价格从高到低排序
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Goods && o2 instanceof Goods) {
                    Goods g1 = (Goods) o1;
                    Goods g2 = (Goods) o2;
                    if (g1.getName().equals(g2.getName())) {
                        return -Double.compare(g1.getPrice(), g2.getPrice());
                    } else {
                        return g1.getName().compareTo(g2.getName());
                    }
                }
                throw new RuntimeException("输出的内容不符合数据类型");
            }

        });
        System.out.println(Arrays.toString(arr));//[Goods{name='dellmouse', price=56.0}, Goods{name='huaweimouse', price=79.0}, Goods{name='lenovomouse', price=35.0}, Goods{name='microsoftmouse', price=90.0}, Goods{name='microsoftmouse', price=56.0}, Goods{name='xiaomimouse', price=12.0}]
    }
}
