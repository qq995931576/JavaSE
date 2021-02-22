package com.thread.java2;

/**
 * 线程通讯的例子: 使用两个线程打印1-100。线程1，线程2 交替打印
 * <p>
 * 涉及到的3个方法:
 * 1. wait(): 一旦执行此方法，当前线程就进入阻塞状态。并释放同步监视器。
 * 2. notify(): 一旦执行此方法，就会唤醒被wait的一个线程。如果有多个线程被wait，就唤醒优先级高的线程。
 * 3. notifyAll(): 一旦执行此方法，就会唤醒被所以wait的线程。
 * <p>
 * 说明:
 * 1. wait()，notify()，notifyAll() 三个方法必须使用在同步代码块或同步方法中。
 * 2. wait()，notify()，notifyAll() 三个方法的调用者必须是同步代码块或同步方法中的同步监视器。
 * 否则会出现IllegalMonitorStateException异常
 * 3. wait()，notify()，notifyAll() 三个方法是定义在java.lang.Object类中。
 * <p>
 * 面试题: sleep() 和 wait() 的异同？
 * 相同点: 一旦执行方法都可以使当前线程进入阻塞状态
 * 不同点: 1) 两个方法的声明位置不一样: Thread类中声明sleep()，Object类中声明wait()
 * 2) 调用的要求不同: sleep()可以在任何需要的场景下调用。
 * wait()必须使用在同步代码块或同步方法中。
 * 3) 关于是否释放同步监视器:
 * 如果两个方法都使用在同步代码块或同步方法中，sleep()不会释放锁；
 * wait()会释放锁，并需要通过notify()来唤醒。
 *
 * @author 阿昌
 * @create 2020-10-08 16:30
 */

class Number implements Runnable {
    private int number = 1;

    @Override
    public void run() {
        while (true) {

            synchronized (this) {
                notify();
                if (number <= 100) {

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + " : " + number);
                    number++;

                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                } else {
                    break;
                }
            }

        }
    }
}

public class CommunicationTest {

    public static void main(String[] args) {
        Number n = new Number();

        Thread t1 = new Thread(n);
        Thread t2 = new Thread(n);

        t1.setName("线程1");
        t2.setName("线程2");

        t1.start();
        t2.start();
    }

}
