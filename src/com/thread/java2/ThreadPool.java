package com.thread.java2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 创建线程的方式四: 使用线程池
 * 1. 提供指定线程数量的线程池
 * 2. 执行指定的线程操作。 需要提供提示Runnable接口或Callable接口实现类的对象
 * 3. 关闭连接池
 * <p>
 * 好处:
 * 1. 提高响应效率(减小创建新线程的时间)
 * 2. 降低资源的消耗(重复利用，而不是再造)
 * 3. 便于线程的管理
 * corePoolSize: 核心池的大小
 * maximumPoolSize: 最大线程数
 * keepAliveTime: 线程没有任务时最多保持多长时间会终止
 * ...
 * 面试题: 创建多线程有几种方式?
 * 4种; Thread类继承、
 * Runnable类接口实现，
 * Callable接口
 * 线程池
 *
 * @author 阿昌
 * @create 2020-10-08 19:48
 */
class NumberThread implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + "： " + i);
            }
        }
    }
}

public class ThreadPool {
    public static void main(String[] args) {
        //1. 提供指定线程数量的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        //2. 执行指定的线程操作。 需要提供提示Runnable接口或Callable接口实现类的对象
        executorService.execute(new NumberThread());//适合使用于Runnable
        executorService.execute(new NumberThread1());
        //executorService.submit();//适合使用于Callable

        //3. 关闭连接池
        executorService.shutdown();
    }
}

class NumberThread1 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + "： " + i);
            }
        }
    }
}
