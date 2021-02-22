package com.collection.exer1;

import org.junit.Test;

import java.util.HashSet;

public class CollectionTest {
    @Test
    public void test1() {
        HashSet set = new HashSet();
        Person p1 = new Person(1001, "AA");
        Person p2 = new Person(1002, "BB");

        set.add(p1);
        set.add(p2);
        System.out.println(set);

        p1.name = "CC";
        set.remove(p1);
        System.out.println(set);//输出两个
        set.add(new Person(1001, "CC"));
        System.out.println(set);//输出三个
        set.add(new Person(1001, "AA"));
        System.out.println(set);//输出四个

    }
}
