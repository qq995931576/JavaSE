package com.collection.java1;

import com.sun.org.apache.bcel.internal.generic.NEW;
import org.junit.Test;

import java.util.*;

public class TreeMapTest {

    //向TreeMap中添加key-value,要求key必须是由同一个类创建的对象
    //因为要按照key进行排序: 自然排序 与 定制排序

    //自然排序
    @Test
    public void test() {
        TreeMap map = new TreeMap();
        User u1 = new User("Tom", 23);
        User u2 = new User("Kim", 16);
        User u3 = new User("Jerry", 21);
        User u4 = new User("Rock", 62);
        map.put(u1, 88);
        map.put(u2, 96);
        map.put(u3, 75);
        map.put(u4, 100);

        Set entrySet = map.entrySet();
        Iterator iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            Map.Entry entry = (Map.Entry) obj;
            System.out.println(entry.getKey() + "---->" + entry.getValue());
        }
    }

    //定制排序
    @Test
    public void test1() {
        TreeMap map = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof User && o2 instanceof User) {
                    User u1 = (User) o1;
                    User u2 = (User) o2;
                    return Integer.compare(u1.getAge(), u2.getAge());//按照年龄从小到大
                }
                throw new RuntimeException("输出的类型有误");
            }
        });
        User u1 = new User("Tom", 23);
        User u2 = new User("Kim", 16);
        User u3 = new User("Jerry", 21);
        User u4 = new User("Rock", 62);
        map.put(u1, 88);
        map.put(u2, 96);
        map.put(u3, 75);
        map.put(u4, 100);

        Set entrySet = map.entrySet();
        Iterator iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            Map.Entry entry = (Map.Entry) obj;
            System.out.println(entry.getKey() + "---->" + entry.getValue());
        }
    }
}
