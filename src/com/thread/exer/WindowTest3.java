package com.thread.exer;

/**
 * 使用 同步方法 来解决继承Thread类实现多线程安全问题
 *
 * @author 阿昌
 * @create 2020-10-07 19:48
 */
class Window3 extends Thread {

    private static int ticket = 100;

    @Override
    public void run() {
        while (true) {

            show();

        }
    }

    private static synchronized void show() {//同步监视器: Window3.class
        //private  synchronized void show(){//同步监视器:this: w1，w2，w3。此种解决方法是错误的
        if (ticket > 0) {

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ": 买票，票号为: " + ticket);
            ticket--;

        }
    }
}


public class WindowTest3 {
    public static void main(String[] args) {
        Window3 w1 = new Window3();
        Window3 w2 = new Window3();
        Window3 w3 = new Window3();

        w1.setName("窗口1");
        w2.setName("窗口2");
        w3.setName("窗口3");

        w1.start();
        w2.start();
        w3.start();
    }
}
