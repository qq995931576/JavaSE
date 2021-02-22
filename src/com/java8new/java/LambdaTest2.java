package java8new.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Java内置四大核心函数式接口
 * <p>
 * 消费型接口 Consumer<T>    void accept(T t)
 * 供给型接口 Supplier<T>    T get()
 * 函数型接口 Function<T,R>  R apply(T t)
 * 断定型接口 predicate<T>   boolean test<T t>
 *
 * @author 阿昌
 * @create 2020-10-19 19:40
 */
public class LambdaTest2 {
    //例子1
    @Test
    public void test1() {
        //之前的写法
        happyTime(500, new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println("这瓶水的价格为: " + aDouble);
            }
        });

        System.out.println("=====================================");//分割线

        //Lambda表达式写法
        happyTime(400, m -> System.out.println("这饼花费了: " + m));

    }

    public void happyTime(double money, Consumer<Double> con) {
        con.accept(money);
    }


    //例子2
    @Test
    public void test2() {
        //之前写法
        List<String> list = Arrays.asList("温州", "台州", "杭州", "衢州", "福州");
        List<String> filterStrs = filterString(list, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("州");
            }
        });
        System.out.println(filterStrs);

        System.out.println("==================================================");//分割线

        //Lambda表达式写法
        List<String> filterStrs1 = filterString(list, s -> s.contains("州"));
        System.out.println(filterStrs1);

    }

    //根据给定的规则，过滤集合中的字符串。此规则由Predicate的方法结局
    public List<String> filterString(List<String> list, Predicate<String> pre) {
        ArrayList<String> filterlist = new ArrayList<>();
        for (String s : list) {
            if (pre.test(s)) {
                filterlist.add(s);
            }
        }

        return filterlist;
    }

}
