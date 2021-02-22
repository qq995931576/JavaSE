package com.thread.java;

/**
 * 测试Thread类中的常用方法:
 * 1. start(): 启动当前线程;调用当前线程的run()方法
 * 2. run(): 通常需要重写Thread类中的此方法，将创建的线程要执行的操作，声明在此方法中
 * 3. currentThread(): 静态方法，返回执行当前代码的线程
 * 4. getName(): 获取当前线程的名字
 * 5. setName(): 设置当前线程的名字
 * 6. yield(): 释放当前CPU的执行权
 * 7. join(): 在线程A中调用线程B的join()，此时线程A进入阻塞状态，直到线程B完全执行完以后，线程A才结束阻塞状态。
 * 8. stop(): 已过时。当执行此方法时，强制结束当前线程
 * 9. sleep(long millis): 让当前线程"睡眠"指定的millitime毫秒。在指定的millitime毫秒时间内，当前线程是阻塞状态。
 * 10. isAlive(): 判断当前线程是否存活
 * <p>
 * <p>
 * 线程的优先级:
 * 1.
 * MAX_PRIORITY：10
 * MIN_PRIORITY: 1
 * NORM_PRIORITY:5  -->默认优先级
 * 2.如何设置当前线程的优先级
 * getPriority(): 获取程序的优先级
 * setPriority(int p): 设置线程的优先级
 * <p>
 * 说明: 高优先级的线程要抢占低优先级线程CPU的执行权。但只是从概率上讲，高优先级的线程高概率的情况下呗执行。
 * 并不意味着只有当高优先级线程执行完以后，低优先级线程才执行。
 *
 * @author 阿昌
 * @create 2020-10-06 19:48
 */
class HelloThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {

//                try {
//                    Thread.currentThread().sleep(10);
//                } catch (InterruptedException e) {
////                    e.printStackTrace();
//                }
                System.out.println(Thread.currentThread().getName() + ":  " + Thread.currentThread().getPriority() + ": " + i);
            }

            //yield(): 释放当前CPU的执行权
//            if (i % 20 == 0){
//                yield();
//            }
        }
    }

    public HelloThread(String name) {
        super(name);
    }
}


public class ThreadMethodTest {
    public static void main(String[] args) {
        HelloThread ht = new HelloThread("Thread: 1");

//        ht.setName("线程一");

        //设置分线程的优先级
        ht.setPriority(1);

        ht.start();

        //给主线程命名
        Thread.currentThread().setName("主线程");
        Thread.currentThread().setPriority(10);

        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":  " + Thread.currentThread().getPriority() + ": " + i);
            }

//            if (i == 20){
//                try {
//                    ht.join();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }

        }

        System.out.println(ht.isAlive());

    }
}
