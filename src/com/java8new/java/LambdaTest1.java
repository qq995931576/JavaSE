package java8new.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Consumer;

/**
 * Lambda表达式的使用
 * <p>
 * 1.举例: (o1,o2) -> Integer.compare(o1,o2);
 * 2.格式:
 * -> :lambda操作符 或 箭头操作符
 * ->的左边: lambda形参列表   (其实就是接口中的抽象方法的形参列表)
 * ->的右边: lambda体 (其实就是重写的抽象方法的方法体)
 * <p>
 * 3.Lambda表达式的使用: (分为6种情况)
 * <p>
 * 总结:
 * ->左边: lambda形参列表可以省略(类型推断);
 * 如果参数列表没有参数，则保留小括号: (s) ->
 * 如果参数列表只有一个参数，其一对小括号也可省略: s ->
 * 如果参数列表有两个或两个以上的参数，则保留小括号和多个参数: (o1,o2,...) ->
 * ->右边: lambda体应该使用一对{}包裹;
 * 如果lambda体只有一条执行语句(可能是return语句)，可以省略这一对{}和return关键字
 * <p>
 * <p>
 * 4.Lambda表达式的本质: 作为接口的实例
 * <p>
 * 5.条件:
 * 一个接口仅有一个待实现方法
 * <p>
 * 6.说明:
 * 如果一个接口中，只声明了一个抽象方法，则此接口就成为函数式接口
 * 我们可以在一个接口上使用@FunctionalInterface注解，这样做可以检验它是否是一个函数式接口。
 * 所以以前用匿名实现类表示的现在都可以用Lambda表达式
 *
 * @author 阿昌
 * @create 2020-10-18 17:29
 */
public class LambdaTest1 {
    //语法格式一: 无参，无返回值
    @Test
    public void test() {
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
        Runnable r2 = () -> {
            System.out.println("我爱温州江心屿");
        };
        r2.run();

    }

    //语法格式二: Lambda 需要一个参数，但是没有返回值。
    @Test
    public void test1() {
        //之前写法
        Consumer<String> con = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        con.accept("谎言和誓言的区别是什么？");

        System.out.println("==========================================");

        //Lambda表达式写法   ->
        Consumer<String> con1 = (String s) -> {
            System.out.println(s);
        };
        con1.accept("一个是听的人当真了，一个是说的人当真了");

    }

    //语法结构三: 数据类型可以省略，因为可由编译器推断得出，称为"类型推断"
    @Test
    public void test2() {

        //之前的写法
        Consumer<String> con1 = (String s) -> {
            System.out.println(s);
        };
        con1.accept("一个是听的人当真了，一个是说的人当真了");

        System.out.println("==========================================");

        //类型推断写法
        Consumer<String> con2 = (s) -> {
            System.out.println(s);
        };
        con2.accept("一个是听的人当真了，一个是说的人当真了");

        //之前出现的情况:↓
        ArrayList<String> list = new ArrayList<>();//类型推断

        //int[] arr = new int[]{1,2,3}; //之前写法
        int[] arr = {1, 2, 3};//类型推断

    }

    //语法结构四: Lambda若只需要一个参数时，参数的小括号可省略
    @Test
    public void test3() {
        //之前写法
        Consumer<String> con1 = (s) -> {
            System.out.println(s);
        };
        con1.accept("一个是听的人当真了，一个是说的人当真了");

        System.out.println("====================================================");

        Consumer<String> con2 = s -> {
            System.out.println(s);
        };
        con2.accept("一个是听的人当真了，一个是说的人当真了");

    }

    //语法结构五: Lambda需要两个或以上的参数，多条执行语句，并且可以有返回值
    @Test
    public void test4() {
        //之前写法
        Comparator<Integer> con1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                System.out.println(o1);
                System.out.println(o2);
                return o1.compareTo(o2);
            }
        };
        System.out.println(con1.compare(12, 45));

        System.out.println("========================================");

        //Lambda表达式写法
        Comparator<Integer> con2 = (o1, o2) -> {
            System.out.println(o1);
            System.out.println(o2);
            return o1.compareTo(o2);
        };
        System.out.println(con2.compare(12, 2));

    }

    //语法格式六: 当Lambda体只有一条执行语句时，return与大括号若有，都可以省略
    @Test
    public void test5() {
        //例子1
        //之前写法
        Comparator<Integer> con1 = (o1, o2) -> {
            return o1.compareTo(o2);
        };
        System.out.println(con1.compare(12, 2));

        System.out.println("===================================");

        //Lambda表达式写法
        Comparator<Integer> con2 = (o1, o2) -> o1.compareTo(o2);
        System.out.println(con2.compare(12, 42));

        System.out.println("**************************************************************************************");

        //例子2
        //之前写法
        Consumer<String> con = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        con.accept("谎言和誓言的区别是什么？");

        System.out.println("=============================================");

        //Lambda表达式写法
        Consumer<String> cons = s -> System.out.println(s);
        cons.accept("谎言和誓言的区别是什么？");

    }

}
