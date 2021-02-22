package com.thread.exer;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 问题:
 * 银行有一个账户。
 * 有两个储户分别向同一个账户存3000元，每次存1000，存3次。每次存完打印账户余额。
 *
 * @author 阿昌
 * @create 2020-10-08 11:33
 */

class Bank implements Runnable {

    private double money = 0;
    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {

        try {
            lock.lock();
            for (int i = 0; i < 3; i++) {

                if (i < 3) {
                    money = money + 1000;
                    System.out.println(Thread.currentThread().getName() + ": 账户的余额为:" + money);
                }

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        } finally {
            lock.unlock();
        }

    }
}

public class BankDemo {
    public static void main(String[] args) {
        Bank b = new Bank();

        Thread t1 = new Thread(b);
        Thread t2 = new Thread(b);

        t1.setName("储户1");
        t2.setName("储户2");

        t1.start();
        t2.start();

    }
}
