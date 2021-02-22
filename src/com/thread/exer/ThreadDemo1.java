package com.thread.exer;

/**
 * 两种方式方式实现遍历100以内的自然数
 *
 * @author 阿昌
 * @create 2020-10-07 12:29
 */

//方式一:继承Thread类的方式
class OThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(getName() + " : " + i);
        }
    }
}

//方式二:实现Runnable接口的方式
class TThread implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
        }
    }
}

public class ThreadDemo1 {
    public static void main(String[] args) {
        //方式一:继承Thread类的方式
        OThread t1 = new OThread();
        t1.setName("线程一");
        t1.start();

        //方式二:实现Runnable接口的方式
        TThread tThread = new TThread();
        Thread t2 = new Thread(tThread);
        t2.setName("线程二");
        t2.start();
    }
}
