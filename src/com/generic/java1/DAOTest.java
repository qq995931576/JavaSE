package com.generic.java1;

import org.junit.Test;

import java.util.List;

public class DAOTest {
    @Test
    public void test1() {
        CustomerDAO dao1 = new CustomerDAO();
        dao1.add(new Customer());
        List<Customer> list = dao1.getForList(5);
    }
}
