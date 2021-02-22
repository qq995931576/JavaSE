package com.iostream.java;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/*
RandomAccessFile的使用
    1. RandomAccessFile直接继承于java.lang.Object类,实现了DateInput和DateOutput接口
    2. RandomAccessFile既可以作为一个输入流,又可以作为一个输出流。
    3. 如果RandomAccessFile作为输出流时,写出到的文件如果不存在,则在执行时自动创建。
                                     写出到的文件存在,则会对原有文件内容,进行覆盖。(默认情况下,从头覆盖)
    4. 可以通过相关的操作实现RandomAccessFile"插入"数据的效果
 */
public class RandomAccessFileTest {

    @Test
    public void test1() {
        RandomAccessFile raf1 = null;
        RandomAccessFile raf2 = null;
        try {
            //1.
            raf1 = new RandomAccessFile(new File("灯光.png"), "r");
            raf2 = new RandomAccessFile(new File("灯光6.png"), "rw");
            //2.
            byte[] buffer = new byte[20];
            int len;
            while ((len = raf1.read(buffer)) != -1) {
                raf2.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //3.
            if (raf1 != null) {
                try {
                    raf1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (raf2 != null) {
                    try {
                        raf2.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    @Test
    public void test2() throws IOException {
        RandomAccessFile raf1 = new RandomAccessFile(new File("hi.txt"), "rw");

        byte[] buffer = new byte[5];

        raf1.seek(3);//讲指针调到角标为3的位置(默认为0)   raf1.length()在文件最后写入内容
        raf1.write("Oni_PePe".getBytes());//覆盖数据

        raf1.close();

    }

    /*
    使用RandomAccessFile实现数据的插入效果
     */
    @Test
    public void test3() throws IOException {
        RandomAccessFile raf1 = new RandomAccessFile(new File("hi.txt"), "rw");

        raf1.seek(3);//将指针调到3下标位置
        //保存3下标后面所有数据到stringBuffer中
        StringBuffer stringBuffer = new StringBuffer((int) new File("hi.txt").length());
        byte[] buffer = new byte[5];
        int len;
        while ((len = raf1.read(buffer)) != -1) {
            stringBuffer.append(new String(buffer, 0, len));
        }

        raf1.seek(3);//将指针调到要插入3下标的位置,插入"Oni_pepe"
        raf1.write("Oni_pepe".getBytes());

        //写入保存在StringBuffer内的数据到文件中
        raf1.write(stringBuffer.toString().getBytes());

        raf1.close();

    }
}
