package com.thread.exer;

/**
 * 练习: 创建两个分线程，其中一个线程遍历100以内的偶数，另一个线程遍历100以内的奇数，
 *
 * @author 阿昌
 * @create 2020-10-06 14:44
 */
//方式一: 新建一个类
class OddThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + ": " + i + " 我是奇数");
            }
        }
    }
}

class EvenThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ": " + i + " 我是偶数");
            }
        }
    }
}

public class ThreadDemo {
    public static void main(String[] args) {
//        //线程1
//        OddThread oddThread = new OddThread();
//        oddThread.start();
//
//        //线程2
//        EvenThread evenThread = new EvenThread();
//        evenThread.start();


        //方式二: 创建Thread类的匿名子类的方式
        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if (i % 2 == 0) {
                        System.out.println(Thread.currentThread().getName() + ": " + i + " 我是偶数");
                    }
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if (i % 2 != 0) {
                        System.out.println(Thread.currentThread().getName() + ": " + i + " 我是偶数");
                    }
                }
            }
        }.start();
    }


}
