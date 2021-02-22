package java8new.java2;

import java8new.java1.Employee;
import java8new.java1.EmployeeData;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 测试Stream中间操作
 *
 * @author 阿昌
 * @create 2020-10-20 22:07
 */
public class StreamAPITest1 {
    // 1- 筛选与切片
    @Test
    public void test1() {
        List<Employee> list = EmployeeData.getEmployees();
//  filter(Predicate p) --- 接受Lambda，从流中排除某些元素。
        Stream<Employee> stream = list.stream();
        //查询员工表中薪资大于7000的员工信息
        stream.filter(e -> e.getSalary() > 7000).forEach(System.out::println);

        System.out.println("==========================================================================");//分割线

//  limit(n) --- 截断流，使其元素不超过给定数量。
        //限制输出前5个元素
        list.stream().limit(5).forEach(System.out::println);

        System.out.println("==========================================================================");//分割线

//  skip(n) --- 跳过元素，返回一个扔掉了前 n 个元素的流。若流中的元素不足 n 个，则返回一个空流。与limit(n)互补。
        //跳过前三个数据
        list.stream().skip(3).forEach(System.out::println);

        System.out.println("==========================================================================");//分割线

//  distinct() --- 筛选，通过流所生成元素的 hashCode()和 equals() 去除重复元素
        list.add(new Employee(1010, "刘强东", 40, 8000));
        list.add(new Employee(1010, "刘强东", 40, 8000));
        list.add(new Employee(1010, "刘强东", 42, 8000));
        list.add(new Employee(1010, "刘强东", 40, 8000));

        list.stream().distinct().forEach(System.out::println);

    }

    // 2- 映射
    @Test
    public void test2() {
//  map(Function f) --- 接受一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。
        List<String> list = Arrays.asList("aa", "bb", "cc", "dd");
        list.stream().map(str -> str.toUpperCase()).forEach(System.out::println);
        //练习: 获取员工姓名长度大于3的员工名字
        List<Employee> employees = EmployeeData.getEmployees();
        employees.stream().map(e -> e.getName()).filter(employee -> employee.length() > 3).forEach(System.out::println);

//  flatMap(Function f) --- 接受一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流。
        list.stream().flatMap(StreamAPITest1::fromStringToStream).forEach(System.out::println);

    }

    public static Stream<Character> fromStringToStream(String str) {
        ArrayList<Character> list = new ArrayList<>();
        for (Character c : str.toCharArray()) {
            list.add(c);
        }
        return list.stream();
    }

    // 3- 排序
    @Test
    public void test3() {
//sorted()---自然排序
        List<Integer> list = Arrays.asList(12, -54, 32, 8, 146, 21, 1);
        list.stream().sorted().forEach(System.out::println);//内部调用了Integer内部的自然排序

        //抛异常: 原因---Employee类没有实现Comparable()
//        List<Employee> employeeList = EmployeeData.getEmployees();
//        employeeList.stream().sorted().forEach(System.out::println);

//sorted(Comparator com)---定制排序
        List<Employee> employeeList = EmployeeData.getEmployees();
        employeeList.stream().sorted((e1, e2) -> {
            int compare = Integer.compare(e1.getAge(), e2.getAge());
            if (compare != 0) {
                return compare;
            } else {
                int compare1 = Double.compare(e1.getSalary(), e2.getSalary());
                return compare1;

            }
        }).forEach(System.out::println);

    }

}
