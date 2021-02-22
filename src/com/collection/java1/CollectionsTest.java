package com.collection.java1;

//Collections:  操作Collection(List、Set)、Map的工具类

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//面试题: Collection 与 Collections的区别？
//Collection 是 接口
//Collections 是操作Collection接口的 工具类
public class CollectionsTest {

    /*
    reverse(List): 反转 List 中元素的顺序
    shuffle(List): 对 List 集合元素进行随机排序
    sort(List): 根据元素的自然顺序对指定 List 集合元素按升序排序
    sort(List,Comparator): 根据指定的 Comparator 产生的顺序对 List 集合元素进行排序
    swap(List,int i,int j): 将指定 List 集合中的 i 处元素 和 j 处元素进行交换

    Object max(Collection): 根据元素的自然顺序,返回给定集合中的最大元素
    Object max(Collection,Comparator): 根据Comparator指定的顺序,返回给定集合中的最大元素
    Object min(Collection): 根据元素的自然顺序,返回给定集合中的最小元素
    Object min(Collection,Comparator): 根据Comparator指定的顺序,返回给定集合中的最小元素
    int frequency(Collection,Object): 返回指定集合中指定元素的出现次数
    void copy(List dest,List src): 将src中的内容复制到dest中
    boolean replaceAll(List list,Object oldVal,Object newVal): 使用新值替换 List对象 的所有旧值

     */

    @Test
    public void test1() {
        List list = new ArrayList();
        list.add(123);
        list.add(23);
        list.add(-3252);
        list.add(4278);
        list.add(468);
        list.add(3);

        System.out.println(list);//[123, 23, -3252, 4278, 468, 3]

//        Collections.reverse(list);//反转list数据;   返回void 修改list本身

//        Collections.shuffle(list);//随机化list数据;

//        Collections.sort(list);//自然排序list数据;    从小到大排序

//        Collections.swap(list,1,3);//交换list集合中索引1和索引3元素的位置

//        Comparable max = Collections.max(list);//返回list集合中最大的元素
//        System.out.println(max);////

//        Comparable min = Collections.min(list);//返回list集合中最小的元素
//        System.out.println(min);//

//        int frequency = Collections.frequency(list, 23);//返回list集合 23 的出现频率
//        System.out.println(frequency);

        System.out.println(list);
    }

    //copy()方法的测试:
    @Test
    public void test2() {
        List list = new ArrayList();
        list.add(123);
        list.add(23);
        list.add(-3252);
        list.add(3);

        //错误的写法:    报错 IndexOutOfBoundsException: Source does not fit in dest
//        List dest = new ArrayList();
//        Collections.copy(dest,list);

        //正确写法:
        List dest = Arrays.asList(new Object[list.size()]);
        System.out.println(dest.size());//list.size();
        Collections.copy(dest, list);

        System.out.println(dest);

        /*
        Collection类中提供了多个synchronizedXxx()方法,
        该方法可使将指定集合包装成线程同步的集合,
        从而可以解决多线程并发访问集合时的线程安全问题。
         */

        //返回的list1即为线程安全的list
        List list1 = Collections.synchronizedList(list);

    }
}
