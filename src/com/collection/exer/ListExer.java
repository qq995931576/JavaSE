package com.collection.exer;

import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;

public class ListExer {

    //区分List当中remove(int index)和remove(Object obj)方法
    @Test
    public void testListRemove() {
        ArrayList list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        updateList(list);
        System.out.println(list);//[1, 2]
    }

    public void updateList(ArrayList list) {
        list.remove(2);
    }
}
