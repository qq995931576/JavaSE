package com.collection.java;


import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetTest {

    /*
    1. 向TreeSet中添加的数据,要求是由相同类的对象
    2. 两种排序方式: 自然排序(实现Comparable接口) 和 定制排序(Comparator)
    3. 自然排序中，比较两个对象是否相同的标准为:compareTo()返回0,不在是equals()方法
    4. 定制排序中，比较两个对象是否相同的标准为:compare()返回0,不在是equals()方法
     */
    @Test
    public void test1() {
        TreeSet treeSet = new TreeSet();

        //失败: 不能添加不同类的对象:
//        treeSet.add(156);
//        treeSet.add(167);
//        treeSet.add("aa");
//        treeSet.add(new User("Jeyy",12));
        //ClassCastException

        //举例一:
//        treeSet.add(34);
//        treeSet.add(912);
//        treeSet.add(-41);
//        treeSet.add(2);

        //举例二:
//          treeSet.add("obi");
//          treeSet.add("GG");
//          treeSet.add("JJ");
//          treeSet.add("MM");

        treeSet.add(new User("Jeyy", 12));
        treeSet.add(new User("Tom", 23));
        treeSet.add(new User("Tom", 56));
        treeSet.add(new User("Mike", 2));
        treeSet.add(new User("Bob", 42));

        Iterator iterator = treeSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test2() {
        Comparator com = new Comparator() {
            //按照年龄从小到大排列
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof User && o2 instanceof User) {
                    User u1 = (User) o1;
                    User u2 = (User) o2;
                    return Integer.compare(u1.getAge(), u2.getAge());
                } else {
                    throw new RuntimeException("输入有误");
                }
            }
        };


        TreeSet set = new TreeSet(com);
        set.add(new User("Jeyy", 12));
        set.add(new User("Tim", 23));
        set.add(new User("Tom", 56));
        set.add(new User("Mike", 2));
        set.add(new User("Bob", 42));
        set.add(new User("Nike", 42));

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
