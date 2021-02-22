package com.thread.exer;

/**
 * 例子:
 * 创建三个窗口，总票数为100张，使用继承Thread类的方式实现
 * <p>
 * 存在线程安全问题,待解决。
 * ↓  ↓  ↓  ↓  ↓  ↓
 * 使用同步代码块来解决继承Thread类的方式的线程安全问题
 * <p>
 * 说明: 在继承Thread类创建多线程的方式中，慎用this充当同步监视器。考虑使用当前类充当同步监视器。
 *
 * @author 阿昌
 * @create 2020-10-07 10:09
 */

class Window extends Thread {

    private static int ticket = 100;
    static Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            //错误的方式: this代表的t1,t2,t3三个对象
            //synchronized(this){
            //正确的
//          synchronized(obj){
            synchronized (Window.class) { //Class clazz = Window.class；Window.class只会加载一次


                if (ticket > 0) {

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(getName() + ": 买票，票号为: " + ticket);
                    ticket--;
                } else {
                    System.out.println(getName() + "票已售空");
                    break;
                }
            }
        }
    }
}


public class WindowTest {
    public static void main(String[] args) {
        Window w1 = new Window();
        Window w2 = new Window();
        Window w3 = new Window();

        w1.setName("窗口1");
        w2.setName("窗口2");
        w3.setName("窗口3");

        w1.start();
        w2.start();
        w3.start();
    }
}
