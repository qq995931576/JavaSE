package com.generic.exer3;

import org.junit.Test;

import java.io.File;
import java.util.*;

public class TraversalMapTest {

    //如何遍历Map的key集，value集，key-value集，使用泛型
    @Test
    public void MapTest() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("小明", 12);
        map.put("小红", 16);
        map.put("小张", 18);
        map.put("小刘", 10);
        //遍历key
        Set<String> strings = map.keySet();
        Iterator<String> iterator1 = strings.iterator();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }
        System.out.println();
        //遍历value
        Collection<Integer> values = map.values();
        Iterator<Integer> iterator2 = values.iterator();
        while (iterator2.hasNext()) {
            System.out.println(iterator2.next());
        }
        System.out.println();
        //遍历key-value
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        Iterator<Map.Entry<String, Integer>> entryIterator = entries.iterator();
        while (entryIterator.hasNext()) {
            Map.Entry<String, Integer> next = entryIterator.next();
            String key = next.getKey();
            Integer value = next.getValue();
            System.out.println("key = " + key + " value = " + value);
        }
    }

    //提供一个方法，用于遍历获取HashMap<String,String>中的所有value,并存放在list中返回。使用泛型
    @Test
    public List<String> changeTest(HashMap<String, String> map) {
        Collection<String> value = map.values();
        ArrayList<String> list = new ArrayList<>();
        Iterator<String> iterator = value.iterator();
        for (String s : value) {
            list.add(s);
        }
        return list;
    }

    //创建一个与a.txt文件同目录下的另外一个文件b.txt
    File file1 = new File("d:\\a\\a.txt");
    File file2 = new File(file1.getParent(), "b.txt");

    //Map接口中的常用方法有哪些?
    /*
    增: put(K k,V v)
    删: V remove(K v)
    改: put(K k,V v)
    查: V get(K k)
    遍历: K keySet()、V value()、Map.Entry(K,V) entrySet()
    长度: int size()
     */
}
