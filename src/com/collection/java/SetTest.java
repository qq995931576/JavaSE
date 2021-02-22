package com.collection.java;

import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/*
1.Set接口的框架结构
     |----Collection接口: 单列集合，用来存储一个一个的对象
          |----Set接口: 存储无序的、不可重复的数据 ---> 高中讲的"集合"
                |----HashSet: 作为Set接口的主要实现类;线程不安全的;可以存储null值
                    |----LinkedHashSet: 作为HashSet的子类,遍历其内部数据时,可以按照添加的顺序去遍历
                                        对于比较频繁的遍历操作,LinkedHashSet效率要 高于HashSet
                |----TreeSet: 可以按照添元素的指定属性，进行排序

说明:
1.Set接口中没有额外定义新的方法,使用的都是Collection中声明过的方法。
2.要求：向Set（主要: HashSet、LinkedHashSet）中添加的数据，其所在的类一定要重写hashCode() 和 equals()
       重写的的hashCode() 和 equals()方法尽可能保持一致性:相等的对象必须具有相等的散列码
 重写两方法小技巧:对象中用作equals()方法比较的Field,都应该用来计算hashCode值


 */
public class SetTest {
    /*
    一.Set: 存储无序的、不可重复的数据
        以HashSet为例说明:
        1. 无序性: 不等于随机性。存储的数据在底层数组中并非按照数组索引的顺序添加，而是根据数据的哈希值觉得的。
        2. 不可重复性: 保证添加的元素按照equals()方法判断时,不能返回true.即:相同的元素只能添加一个

    二.添加元素的过程:
        以HashSet为例:
            我们向HashSet中添加元素a,首先调用元素a所在类的hashCode()方法，计算元素a的哈希值，
            此哈希值接着通过某种算法计算出在HashSet底层数组中的存放位置(即为:索引位置),判断数组
            此位置上是否已经有元素:
                如果此位置上没有元素，则元素a添加成功。 --->情况1
                如果此位置上有其他元素b(或以链表形式存在的多个元素),则比较元素a与元素b的哈希值:
                    如果哈希值不相同，则元素a添加成功。 --->情况2
                    如果哈希值相同,进而需要调用元素a所在类的equals()方法:
                        equals()返回true,元素a与对比元素一样，元素a添加失败
                        equals()返回false,元素a与现有的元素不一样，则元素a添加成功 --->情况3
            说明：
            对于添加成功的情况2和情况3而言: 元素a与已经存在指定索引位置上的数据以链表的方式存储。
            jdk 7 :元素a 放到数组中，并指向原来的元素。
            jdk 8 :原来的元素放在数组中，并指向元素a
            ↑总结:7上8下

            HashSet底层: 数组 + 链表 的结构。(jdk 7)
     */

    @Test
    public void test1() {
        Set set = new HashSet();
        set.add(156);
        set.add(156);
        set.add("asd");
        set.add("CC");
        set.add(new User("Tom", 13));
        set.add(new User("Tom", 13));
        set.add(8462);

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    //LinkedHashSet的使用
    //LinkedHashSet作为HashSet的子类,在添加数据的同时,每一个数据还维护了两个引用，来记录此数据前一个数据和后一个数据。
    //目的: 对于比较频繁的遍历操作,LinkedHashSet效率要 高于HashSet
    public void test2() {
        Set set = new LinkedHashSet();
        set.add(156);
        set.add(156);
        set.add("asd");
        set.add("CC");
        set.add(new User("Tom", 13));
        set.add(new User("Tom", 13));
        set.add(8462);

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
