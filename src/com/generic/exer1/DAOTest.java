package com.generic.exer1;

import org.junit.Test;

import java.util.List;

//创建 DAO 类的对象，
// 分别调用其 save、get、update、list、delete 方法来操作 User 对象
// 使用 Junit 单元测试类进行测试
public class DAOTest {
    public static void main(String[] args) {
        DAO<User> dao = new DAO<>();
        dao.save("1001", new User(1001, 25, "Tom"));
        dao.save("1002", new User(1002, 65, "Kiy"));
        dao.save("1003", new User(1003, 33, "Jerry"));

        dao.update("1001", new User(1005, 21, "PePe"));

        dao.delete("1002");

        List<User> list = dao.list();
//      System.out.println(list);
        list.forEach(System.out::println);// jdk8新特性
    }
}
