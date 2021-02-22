package com.collection.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

//集合元素的遍历操作，使用迭代器Iterator接口
//1. 内部方法: hasNext()和 Next()
//2. 集合对象每次调用iterator()方法都得到一个全新的迭代器对象，
//   默认游标都在集合的第一个元素之前。
//3. Iterator迭代器内部定义了remove()方法，可以在遍历的时候，删除集合中的元素。此方法不同于集合直接调用remove()。

public class iteratorTest {

    @Test
    public void test1() {
        Collection coll = new ArrayList();
        coll.add(1458);
        coll.add(123);
        coll.add(new Person("PePe", 21));
        coll.add(new String("Tom"));

        Iterator iterator = coll.iterator();
        //方式一:
//        System.out.println(iterator.next());//1458
//        System.out.println(iterator.next());//123
//        System.out.println(iterator.next());//Person{name='PePe', age=21}
//        System.out.println(iterator.next());//Tom
//        //报错NoSuchElementException
//        System.out.println(iterator.next());

        //方式二: 不推荐
/*       for (int i = 0; i < coll.size(); i++) {
            System.out.println(iterator.next());  //1458
                                                    //123
                                                    //Person{name='PePe', age=21}
                                                    //Tom
      }
*/
        //方式三: 推荐
        //hasNext(): 判断是否还有下一个元素
        while (iterator.hasNext()) {
            ////next(): ①指针下移 ②将下移以后集合位置上的元素返回
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test2() {
        Collection coll = new ArrayList();
        coll.add(1458);
        coll.add(123);
        coll.add(new Person("PePe", 21));
        coll.add(new String("Tom"));

        Iterator iterator = coll.iterator();

        //错误方式一: 跳着输出
//        while ((iterator.next() != null)){
//            System.out.println(iterator.next());    //123 报错NoSuchElementException
        //                                                   // Tom

        //错误方式二: 一直重复输出第一个元素
        //每次调用iterator()方法都得到一个全新的迭代器对象
        while (coll.iterator().hasNext()) {
            System.out.println(coll.iterator().next());//1458 1458 1458 1458 1458 重复输出
        }
    }

    //测试Iterator中的remove()方法
    //如果还未调用next() 或 在一次调用next()方法之前调用了多次remove方法---->就会报错IllegalStateException
    @Test
    public void test3() {
        Collection coll = new ArrayList();
        coll.add(1458);
        coll.add(123);
        coll.add(new Person("PePe", 21));
        coll.add(new String("Tom"));

        //删除集合中"Tom"数据
        Iterator iterator = coll.iterator();
        while (iterator.hasNext()) {

//          iterator.remove();//报错IllegalStateException
            //不要在没next()之前调用remove()方法

            Object obj = iterator.next();
            if ("Tom".equals(obj)) {
                iterator.remove();

//              iterator.remove();//报错IllegalStateException
                //在下一次next()之前不能调用两次remove()
            }
        }

        //遍历集合
        Iterator iterator1 = coll.iterator();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
                                                /*
                                                1458
                                                123
                                                Person{name='PePe', age=21}
                                                 */
        }

    }
}

