package com.iostream.java;

import org.junit.Test;

import java.io.*;

/*
对象流的使用
1. ObjectInputStream 和 ObjectOutputStream
2. 作用: 用于存储和读取基本数据类型数据或对象的处理流。
        可以把Java中的对象写入到数据源中，也能把对象从数据源中还原回来。
3. 可序列号要求:
    见Person类

4. 序列化机制:
    运行把内存中的Java对象转行为二进制流,从而允许把这二进制流持久地保存在磁盘中，
    或是通过网络将二进制流传输到另一个网络节点。当其他程序获取到这个二进制流，
    就可以将它恢复成原来的Java对象。

 */
public class ObjectInputOutputStreamTest {

    /*
    序列号过程: 将内存中的Java对象保存在磁盘中或通过网络传输出去
    使用ObjectOutputStream实现
     */
    @Test
    public void testObjectOutputStream() {
        ObjectOutputStream oos = null;
        try {
            //1.
            oos = new ObjectOutputStream(new FileOutputStream("object.dat"));
            //2.
            oos.writeObject(new String("我爱敲代码"));
            oos.flush();//刷新操作

            oos.writeObject(new Person("阿昌", 21));
            oos.flush();//刷新操作

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    //3.
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /*
    反序列化过程: 将磁盘文件中的对象还原为内存中的Java对象
    使用ObjectInputStream实现
     */
    @Test
    public void testObjectInputStream() {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("object.dat"));

            Object obj = ois.readObject();
            String str = (String) obj;

            Person p = (Person) ois.readObject();

            System.out.println(str);
            System.out.println(p);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
