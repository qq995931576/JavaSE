package java8new.java;

import org.junit.Test;

import java.util.Comparator;

/**
 * Lambda表达式的使用举例
 *
 * @author 阿昌
 * @create 2020-10-18 17:05
 */
public class LambdaTest {

    @Test
    public void test1() {

        //之前写法
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("我爱温州五马街");
            }
        };
        r1.run();

        System.out.println("===================================================");

        //Lambda表达式写法   ->
        Runnable r2 = () -> System.out.println("我爱温州江心屿");
        r2.run();

    }

    @Test
    public void test2() {

        //之前的写法
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        int c1 = com1.compare(13, 18);
        System.out.println(c1);

        System.out.println("===============================================");

        //Lambda表达式写法   ->
        Comparator<Integer> com2 = (o1, o2) -> Integer.compare(o1, o2);
        int c2 = com2.compare(123, 18);
        System.out.println(c2);

        System.out.println("===============================================");

        //方法引用写法  ::
        Comparator<Integer> com3 = Integer::compare;
        int c3 = com3.compare(123, 18);
        System.out.println(c3);

    }

}
