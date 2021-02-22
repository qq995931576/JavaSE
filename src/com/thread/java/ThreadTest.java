package com.thread.java;

/**
 * 多线程的创建
 * 方式一:继承与Thread类
 * 1. 创建一个继承于Thread类的子类
 * 2. 重写Thread类的run()方法   ---> 将此线程的操作声明在run()中
 * 3. 创建Thread类的子类对象
 * 4. 通过此对象调用start()
 * <p>
 * 例子:遍历100以内的所有偶数
 *
 * @author 阿昌
 * @create 2020-10-06 12:50
 */

//1. 创建一个继承于Thread类的子类
class MyThread extends Thread {
    //2. 重写Thread类的run()方法: 将想要实现的逻辑写入在run()方法中
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}


//多线程的使用
public class ThreadTest {
    public static void main(String[] args) {
        //3. 创建Thread类的子类对象
        MyThread t1 = new MyThread();

        //4. 通过此对象调用start(): ①启动当前线程 ②调用当前线程的run()方法
        t1.start();

        //问题1: 不能直接调用run()来启动线程
//        t1.run();

        //问题2: 再启动一个线程,来遍历100以内的偶数。不可以让已经执行start()的线程去执行。 会报错IllegalThreadStateException
//        t1.start();
        //需要重新创建一个线程的对象
        MyThread t2 = new MyThread();
        t2.start();

        //如下操作仍然是在main线程中执行的。
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i + "===main()===");
            }
        }
    }
}
