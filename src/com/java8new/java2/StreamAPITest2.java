package java8new.java2;

import java8new.java1.Employee;
import java8new.java1.EmployeeData;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 测试Stream终止操作
 *
 * @author 阿昌
 * @create 2020-10-21 21:12
 */
public class StreamAPITest2 {

    // 1 - 匹配与查找
    @Test
    public void test0() {
        List<Employee> employeeList = EmployeeData.getEmployees();

//allMatch(Predicate p) --- 检查是否匹配所有元素。
        // 练习:是否所有的员工的年龄都大于18
        boolean allMatch = employeeList.stream().allMatch(e -> e.getAge() > 18);
        System.out.println(allMatch);

//anyMatch(Predicate p) --- 检查是否至少匹配一个元素。
        // 练习:是否存在员工的工资大于10000
        boolean anyMatch = employeeList.stream().anyMatch(e -> e.getSalary() > 10000);
        System.out.println(anyMatch);

//noneMatch(Predicate p) --- 检查是否没有匹配的元素。
        // 练习: 是否存在员工姓"雷"
        boolean noneMatch = employeeList.stream().noneMatch(e -> e.getName().startsWith("雷"));
        System.out.println(noneMatch);

//findFirst --- 返回第一个元素
        Optional<Employee> first = employeeList.stream().findFirst();
        System.out.println(first);

//findAny --- 返回当前流中的任意元素
        Optional<Employee> any = employeeList.stream().findAny();
        System.out.println(any);

    }

    @Test
    public void test1() {
        List<Employee> employeeList = EmployeeData.getEmployees();
//count --- 返回流中元素的总个数
        long count = employeeList.stream().count();
        System.out.println(count);

//max(Comparator c) --- 返回流中最大值
        // 练习: 返回最高的工资
        Stream<Double> money = employeeList.stream().map(e1 -> e1.getSalary());
        Optional<Double> maxMoney = money.max(Double::compareTo);
        System.out.println(maxMoney);


//min(Comparator c) --- 返回流中最小值
        // 练习: 返回最低工资的员工
        Optional<Employee> employee = employeeList.stream().min((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        System.out.println(employee);


//forEach(Consumer c) --- 内部迭代
        employeeList.stream().forEach(System.out::println);

        //使用集合的遍历操作方法
        employeeList.forEach(System.out::println);

    }


    // 2 - 归约
    @Test
    public void test2() {
//reduce(T identity,BinaryOperator b) --- 可以将流中元素反复结合起来，得到一个值。返回T
        //练习1: 计算1-10的自然数的和
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer reduce = list.stream().reduce(0, Integer::sum);
        System.out.println(reduce);

//reduce(BinaryOperator b) --- 可以将流中元素反复结合起来，得到一个值。返回 Optional<T>
        //练习2: 计算公司所有员工工资的综合
        List<Employee> employeeList = EmployeeData.getEmployees();
//        Optional<Double> reduce1 = employeeList.stream().map(e1 -> e1.getSalary()).reduce(Double::sum);
        Optional<Double> reduce1 = employeeList.stream().map(e1 -> e1.getSalary()).reduce((d1, d2) -> d1 + d2);
        System.out.println(reduce1);

    }


    // 3 - 收集
    @Test
    public void test3() {
//collect(Collection c) --- 将流转换为其他形式。接受一个Collector接口的实现，用于给Stream中元素做汇总的方法
        //练习1: 查找工资大于6000的员工 结果返回为一个List或Set
        List<Employee> employees = EmployeeData.getEmployees();
        List<Employee> employeeList = employees.stream().filter(e -> e.getSalary() > 6000).collect(Collectors.toList());
        employeeList.forEach(System.out::println);

        System.out.println();

        Set<Employee> employeeSet = employees.stream().filter(e -> e.getSalary() > 6000).collect(Collectors.toSet());
        employeeSet.forEach(System.out::println);

    }

}
