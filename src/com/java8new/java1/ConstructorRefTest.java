package java8new.java1;

import org.junit.Test;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 一、构造器引用
 * 和方法引用类似，函数式接口的抽象方法的形参列表和构造器的形参列表一致。
 * 抽象方法的返回值类型即为构造器所属的类的类型
 * <p>
 * 二、数组引用
 * 可以把数组看做一个特殊的类，则写法与构造器引用一致。
 * <p>
 * <p>
 * Created by shkstart
 */
public class ConstructorRefTest {
    //构造器引用
    //Supplier中的T get()
    //Employee的空参构造器: Employee();
    @Test
    public void test1() {
        //原始写法
        Supplier<Employee> sup0 = new Supplier<Employee>() {
            @Override
            public Employee get() {
                return new Employee();
            }
        };
        System.out.println(sup0.get());

        System.out.println("==========================================");//分割线

        //Lambda表达式写法
        Supplier<Employee> sup1 = () -> new Employee();
        System.out.println(sup1.get());

        System.out.println("==========================================");//分割线

        //构造器引用写法
        Supplier<Employee> sup2 = Employee::new;
        System.out.println(sup2.get());

    }

    //Function中的R apply(T t)
    @Test
    public void test2() {
        //Lambda表达式写法
        Function<Integer, Employee> fun1 = id -> new Employee(id);
        Employee employee = fun1.apply(1001);
        System.out.println(employee);

        System.out.println("==========================================");//分割线

        //构造器引用写法
        Function<Integer, Employee> fun2 = Employee::new;
        Employee employee1 = fun2.apply(1002);
        System.out.println(employee1);

    }

    //BiFunction中的R apply(T t,U u)
    @Test
    public void test3() {
        //Lambda表达式写法
        BiFunction<Integer, String, Employee> bif1 = (id, str) -> new Employee(id, str);
        Employee employee = bif1.apply(1001, "张薇");
        System.out.println(employee);

        System.out.println("==========================================");//分割线

        //构造器引用写法
        BiFunction<Integer, String, Employee> bif2 = Employee::new;
        Employee employee1 = bif2.apply(1002, "刘芳");
        System.out.println(employee1);

    }

    //数组引用
    //Function中的R apply(T t)
    @Test
    public void test4() {
        //Lambda表达式写法
        Function<Integer, String[]> func1 = length -> new String[length];
        String[] arr1 = func1.apply(8);
        System.out.println(Arrays.toString(arr1));

        System.out.println("==========================================");//分割线

        //数组引用的写法
        Function<Integer, String[]> func2 = String[]::new;
        String[] arr2 = func2.apply(5);
        System.out.println(Arrays.toString(arr2));

    }

}
