package com.thread.java1;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 解决线程安全问题的方式三: Lock锁 --- jdk5.0新增
 * <p>
 * 1. 面试题: synchronized 与 Lock 的异同?
 * 相同: 二者都可以解决线程安全问题
 * 不同: synchronized机制在执行完相应的同步代码后，自动释放同步监视器
 * Lock需要手动的启动同步(lock())，同时结束同步也需要手动的实现(unlock())。
 * <p>
 * 面试题: 如何解决线程安全问题?有几种方式?
 * 3种;同步代码块、同步方法、Lock锁
 * <p>
 * 2. 优秀使用顺序:
 * Lock --> 同步代码块(已经进入方法体，分配了相应资源) --> 同步方法(在方法体之外)
 *
 * @author 阿昌
 * @create 2020-10-08 10:58
 */
class Window implements Runnable {

    private int ticket = 100;
    //1. 实例化ReentrantLock
    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            try {

                //2. 调用锁定方法: lock()
                lock.lock();

                if (ticket > 0) {

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + " 卖票: " + ticket);
                    ticket--;
                } else {
                    break;
                }
            } finally {
                //3. 调用解锁方法: unlock()
                lock.unlock();
            }
        }
    }
}

public class LockTest {
    public static void main(String[] args) {
        Window w1 = new Window();

        Thread t1 = new Thread(w1);
        Thread t2 = new Thread(w1);
        Thread t3 = new Thread(w1);

        t1.setName("线程1");
        t2.setName("线程2");
        t3.setName("线程3");

        t1.start();
        t2.start();
        t3.start();
    }
}
