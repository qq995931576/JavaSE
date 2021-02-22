package com.thread.exer;

/**
 * 使用 同步方法 解决实现Runnable接口的线程安全问题
 * <p>
 * 关于同步方法的总结:
 * 1. 同步方法仍然涉及到同步监视器，只是不需要我们显示的声明。
 * 2. 非静态的同步方法，同步监视器是: this
 * 静态的同步方法，同步监视器是: 当前类本身
 *
 * @author 阿昌
 * @create 2020-10-07 19:10
 */
class WThread2 implements Runnable {
    private int ticket = 100;

    @Override
    public void run() {
        while (ticket > 0) {

            show();
        }

    }

    private synchronized void show() {// 同步监视器: this
        if (ticket > 0) {

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + " 卖票，票号为: " + ticket);
            ticket--;

        }
    }
}


public class WindowTest2 {
    public static void main(String[] args) {
        WThread2 wThread2 = new WThread2();

        Thread t1 = new Thread(wThread2);
        Thread t2 = new Thread(wThread2);
        Thread t3 = new Thread(wThread2);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");


        t1.start();
        t2.start();
        t3.start();

    }
}
