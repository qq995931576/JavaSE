package com.thread.exer;

/**
 * 线程通信的应用: 经典例题: 生产者/消费者问题
 * <p>
 * 生产者(Productor)将产品交给店员(Clerk)，而消费者(Customer)从店员处取走产品，
 * 店员一次只能持有固定数量的产品(比如:20），如果生产者试图 生产更多的产品，
 * 店员会叫生产者停一下，如果店中有空位放产品了再通知生产者继续生产；
 * 如果店中没有产品了，店员会告诉消费者等一下，
 * 如果店中有产品了再通知消费者来取走产品。
 * <p>
 * 分析:
 * 1. 是否是多线程问题? 是; 生产者线程，消费者线程
 * 2. 是否有线程安全问题? 是; 店员(或产品数量)
 * 3. 如何解决线程安全问题? 同步机制，有三种方法。
 * 4. 是否涉及到线程的通信? 是
 *
 * @author 阿昌
 * @create 2020-10-08 17:56
 */

class Clerk {

    private int productNum = 0;

    //生产产品
    public synchronized void produceProduct() {

        if (productNum < 20) {
            productNum++;
            System.out.println(Thread.currentThread().getName() + ":开始生产第" + productNum + "个产品");
            notify();

        } else {

            //等待
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

    //消费产品
    public synchronized void consumeProduct() {

        if (productNum > 0) {
            System.out.println(Thread.currentThread().getName() + "开始消费第" + productNum + "个产品");
            productNum--;
            notify();
        } else {


            //等待
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}


class Customer extends Thread {//消费者
    private Clerk clerk;

    public Customer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {

        while (true) {
            System.out.println(getName() + "开始消费...");
            clerk.consumeProduct();
        }

    }
}


class Productor extends Thread {//生产者
    private Clerk clerk;

    public Productor(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(getName() + "开始生产...");
            clerk.produceProduct();
        }
    }
}


public class ProdectTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();

        Customer c1 = new Customer(clerk);
        Productor p1 = new Productor(clerk);

        p1.setName("生产者1");
        c1.setName("消费者1");

        p1.start();
        c1.start();
    }
}
