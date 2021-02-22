package com.collection.exer1;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class EmployeeTest {
    //问题二:使用定制排序
    @Test
    public void test2() {
        TreeSet Set = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Employee && o2 instanceof Employee) {
                    Employee e1 = (Employee) o1;
                    Employee e2 = (Employee) o2;

                    MyDate b1 = e1.getBirthday();
                    MyDate b2 = e2.getBirthday();
                    //方式一:
//                    //比较年
//                    int minusYear = b1.getYear()- b2.getYear();
//                    if (minusYear !=0){
//                         return minusYear;
//                    }
//                    //比较月
//                    int minusMonth = b1.getMonth()-b2.getMonth();
//                    if (minusMonth !=0){
//                        return minusMonth;
//                    }
//                    //比较日
//                        return b1.getDay()-b2.getDay();
                    //方式二:
                    return b1.compareTo(b2);

                }
                throw new RuntimeException("输入的数据类型有误");
            }
        });

        Employee e1 = new Employee("guanyu", 39, new MyDate(1241, 11, 3));//数据纯乱写!!!
        Employee e2 = new Employee("zhaoyun", 52, new MyDate(1932, 6, 26));
        Employee e3 = new Employee("zhangfei", 53, new MyDate(1932, 9, 3));
        Employee e4 = new Employee("huangzhong", 98, new MyDate(1179, 7, 15));
        Employee e5 = new Employee("machao", 25, new MyDate(1257, 12, 8));

        Set.add(e1);
        Set.add(e2);
        Set.add(e3);
        Set.add(e4);
        Set.add(e5);

        Iterator iterator = Set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    //问题一:使用自然排序
    @Test
    public void test1() {
        TreeSet treeSet = new TreeSet();
        Employee e1 = new Employee("guanyu", 39, new MyDate(1241, 11, 3));//数据纯乱写!!!
        Employee e2 = new Employee("zhaoyun", 52, new MyDate(1532, 6, 26));
        Employee e3 = new Employee("zhangfei", 16, new MyDate(1932, 9, 3));
        Employee e4 = new Employee("huangzhong", 98, new MyDate(1179, 7, 15));
        Employee e5 = new Employee("machao", 25, new MyDate(1257, 12, 8));

        treeSet.add(e1);
        treeSet.add(e2);
        treeSet.add(e3);
        treeSet.add(e4);
        treeSet.add(e5);

        Iterator iterator = treeSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
