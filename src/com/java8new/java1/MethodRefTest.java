package java8new.java1;

import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 方法引用的使用
 * <p>
 * 1. 使用情景: 当要传递给Lambda体的操作，已经有实现的方法了，可以使用方法引用!
 * <p>
 * 2. 方法引用，本质上就是Lambda表达式，而Lambda表达式作为函数式接口的实例出现的。
 * 所以方法引用，也是函数式接口的实例。
 * <p>
 * 3. 使用的格式: 	类(或对象) :: 方法名
 * <p>
 * 4. 具体分为如下三种情况:
 * 情况1) 对象 :: 非静态方法(实例方法)
 * 情况2) 类  :: 静态方法
 * <p>
 * 情况3) 类  :: 非静态方法
 * <p>
 * 5. 方法引用使用的要求:
 * 要求接口中的抽象方法的形参列表和返回值类型 与 方法引用的方法的形参列表和返回值类型 相同（针对于情况1与情况2）
 * <p>
 * <p>
 * Created by 阿昌
 */
public class MethodRefTest {

    // 情况1：对象 :: 实例方法
    //Consumer中的void accept(T t)
    //PrintStream中的void println(T t)
    @Test
    public void test1() {
        //Lambda表达式写法
        Consumer<String> con1 = str -> System.out.println(str);
        con1.accept("温州");

        System.out.println("===============================================");//分割线

        //方法引用写法
        PrintStream ps = System.out;
        Consumer<String> con2 = ps::println;
        con2.accept("wenzhou");

    }

    //Supplier中的T get()
    //Employee中的String getName()
    @Test
    public void test2() {
        //Lambda表达式写法
        Employee emp = new Employee(1001, "阿昌", 23, 5800);
        Supplier<String> sup1 = () -> emp.getName();
        System.out.println(sup1.get());//阿昌

        System.out.println("==============================================");//分割线

        //方法引用写法
        Supplier<String> sup2 = emp::getName;
        System.out.println(sup2.get());//阿昌

    }

    // 情况2：类 :: 静态方法
    //Comparator中的int compare(T t1,T t2)
    //Integer中的int compare(T t1,T t2)
    @Test
    public void test3() {
        //Lambda表达式写法
        Comparator<Integer> com1 = (t1, t2) -> Integer.compare(t1, t2);
        System.out.println(com1.compare(12, 56));

        System.out.println("==============================================");//分割线

        //方法引用写法
        Comparator<Integer> com2 = Integer::compare;
        System.out.println(com2.compare(76, 21));

    }

    //Function中的R apply(T t)
    //Math中的Long round(Double d)
    @Test
    public void test4() {
        //Lambda表达式写法
        Function<Double, Long> fun1 = d -> Math.round(d);
        System.out.println(fun1.apply(3.14));

        System.out.println("==============================================");//分割线

        //方法引用的写法
        Function<Double, Long> fun2 = Math::round;
        System.out.println(fun2.apply(5.68));

    }

    // 情况3：类 :: 实例方法  (有难度)
    // Comparator中的int comapre(T t1,T t2)
    // String中的int t1.compareTo(t2)
    @Test
    public void test5() {
        //Lambda表达式写法
        Comparator<String> com1 = (s1, s2) -> s1.compareTo(s2);
        System.out.println(com1.compare("abc", "obj"));

        System.out.println("==============================================");//分割线

        //方法引用的写法
        Comparator<String> com2 = String::compareTo;
        System.out.println(com2.compare("abc", "abd"));

    }

    //BiPredicate中的boolean test(T t1, T t2);
    //String中的boolean t1.equals(t2)
    @Test
    public void test6() {
        //Lambda表达式写法
        BiPredicate<String, String> bip1 = (s1, s2) -> s1.equals(s2);
        System.out.println(bip1.test("abc", "abc"));

        System.out.println("==============================================");//分割线

        //方法引用的写法
        BiPredicate<String, String> bip2 = String::equals;
        System.out.println(bip2.test("ifs", "sfo"));

    }

    // Function中的R apply(T t)
    // Employee中的String getName();
    @Test
    public void test7() {
        //Lambda表达式写法
        Function<Employee, String> func1 = e1 -> e1.getName();
        System.out.println(func1.apply(new Employee(1002, "小次郎", 20, 6500)));

        System.out.println("==============================================");//分割线

        //方法引用的写法
        Function<Employee, String> func2 = Employee::getName;
        System.out.println(func2.apply(new Employee(1003, "大裂郎", 41, 200)));

    }

}
