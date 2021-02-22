package com.oop.demo09;

// 抽象类： extends
// 类 可以实现接口 implements 接口
// 实现接口的类，就需要重写接口中的方法

// 多继承；利用接口实现多继承；
public class UserServiceImpl implements UserService, TimeService {//接口可以实现尾多继承

    @Override
    public void run() {//UserService接口重写的方法
    }

    @Override
    public void add(String name) {//UserService接口重写的方法
    }

    @Override
    public void delete(String name) {//UserService接口重写的方法
    }

    @Override
    public void update(String name) {//UserService接口重写的方法
    }

    @Override
    public void query(String name) {//UserService接口重写的方法
    }

    @Override
    public void timer() {//TimeService接口重写的方法
    }
}
