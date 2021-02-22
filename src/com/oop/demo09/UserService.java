package com.oop.demo09;

//抽象的思维
//interface 定义的关键字  接口都需要有实现类
public interface UserService {
    public abstract void run();//--->void run();        注意左边的public abstract是灰色的，正常可以直接这么写void run()

    //常量  public static final
    int age = 66;

    //接口中的所有定义的方法其实都是抽象的 public abstract
    void add(String name);

    void delete(String name);

    void update(String name);

    void query(String name);
}
