package com.thread.java2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 创建线程方式四: 实现Callable接口。  ---  jdk 5.0 新增
 * 1. 创建一个实现Callable的实现类
 * 2. 重写call()方法，将此线程需要执行的操作声明在call()中。
 * 3. 创建Callable接口实现类的对象
 * 4. 将此Callable接口实现类的对象作为参数传递到FutureTask构造器中，创建FutureTask对象
 * 5. 将FutureTask的对象作为参数传递到Thread类的构造器中，创建Thread对象，并调用start()
 * 6. 获取Callable中的call()的返回值
 * <p>
 * 问题:  如何理解实现Callable接口的方式创建多线程比实现Runnable接口创建多线程强大?
 * 1. call()可以有返回值。
 * 2. call()可以抛出异常，被外面的操作捕获，获取异常的信息
 * 3. Callable是支持泛型
 *
 * @author 阿昌
 * @create 2020-10-08 19:02
 */

//1. 创建一个实现Callable的实现类
class NumThread implements Callable {

    //2. 重写call()方法，将此线程需要执行的操作声明在call()中。
    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
                sum += i;
            }
        }
        return sum;
    }
}

public class ThreadNew {
    public static void main(String[] args) {
        //3. 创建Callable接口实现类的对象
        NumThread numThread = new NumThread();

        //4. 将此Callable接口实现类的对象作为参数传递到FutureTask构造器中，创建FutureTask对象
        FutureTask f = new FutureTask<Integer>(numThread);

        //5. 将FutureTask的对象作为参数传递到Thread类的构造器中，创建Thread对象，并调用start()
        new Thread(f).start();

        Object o = null;
        try {
            //6. 获取Callable中的call()的返回值
            //get()的返回值 即为FutureTask构造器参数Callable实现类重写的call()的返回值。
            o = f.get();
            System.out.println("总合为: " + o);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }

}
