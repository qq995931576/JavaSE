package java8new.java2;

import java8new.java1.Employee;
import java8new.java1.EmployeeData;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 1. Stream关注的是对数据的运算，与CPU打交道
 * 集合关注的是数据的存储，与内存打交道
 * <p>
 * 2. Stream 自己不会储存元素。
 * Stream 不会改变源对象。相反，他们会返回一个持有结果的新Stream。
 * Stream 操作是延迟执行的。这意味着他们会等到需要结果的时候才执行
 * <p>
 * 3. Stream 执行流程
 * ① Stream的实例化
 * ② 一系列的中间操作(过滤、映射、...)
 * ③ 终止操作
 * <p>
 * 4. 说明
 * ①一个中间操作链，对数据源的数据进行处理
 * ②一旦执行终止操作，就执行中间操作链，并产生结果。之后，此Stream不能再被使用
 * <p>
 * 测试Stream的实例化
 *
 * @author 阿昌
 * @create 2020-10-20 21:21
 */
public class StreamAPITest {

    //创建Stream方式一: 通过集合
    @Test
    public void test1() {
        List<Employee> employees = EmployeeData.getEmployees();

//      default Stream<E> stream() : 返回一个顺序流
        Stream<Employee> stream = employees.stream();

//      default Stream<E> parallelStream() : 返回一个并行 (并行操作的去获取数据)
        Stream<Employee> parallelStream = employees.parallelStream();

    }

    //创建Stream方式二: 通过数组
    @Test
    public void test2() {
        int[] arr1 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//      调用Arrays类的静态方法: static <T> Stream<T> stream(T[] array): 返回一个
        IntStream stream = Arrays.stream(arr1);

        Employee e1 = new Employee(1001, "李小姐");
        Employee e2 = new Employee(1002, "张先生");
        Employee[] arr2 = new Employee[]{e1, e2};
        Stream<Employee> stream1 = Arrays.stream(arr2);

    }

    //创建Stream方式三: 通过Stream的of()
    @Test
    public void test3() {
        Stream<Integer> integerStream = Stream.of(2, 3, 4, 8, 9, 6);

    }

    //创建Stream方式四: 通过创建无限流
    @Test
    public void test4() {
//   迭代  public static<T> Stream<T> iterate(final T seed, final UnaryOperator<T> f)
        //遍历从前十个偶数
        Stream.iterate(0, t -> t + 2).limit(10).forEach(System.out::println);

//   生成  public static<T> Stream<T> generate(Supplier<T> s)
        //生成输出10个随机数
        Stream.generate(Math::random).limit(10).forEach(System.out::println);

    }

}
