package com.iostream.java;

import org.junit.Test;

import java.io.*;
import java.util.concurrent.CopyOnWriteArrayList;

//测试FileInputStream和FileOutputStream的使用
/*
结论:
    1. 对于文本文件(.txt,.java,.c,.cpp)，使用字符流来处理
    2. 对于非文本文件(.jpg,.mp3,.mp4,.avi,.doc,.ppt,.md,...)，使用字节流来处理


 */

public class FileInputOutputStreamTest {
    //使用字节流FileInputStream处理文本文件,可能出现乱码
    @Test
    public void testFileInputStream() {
        FileInputStream fis = null;
        try {
            // 1.创建File类对象，指明写出的文件
            File file = new File("hello.txt");

            // 2.创建输入对象
            fis = new FileInputStream(file);

            // 3.输入操作
            byte[] cbuf = new byte[5];
            int len;//每次读取的字节的个数
            while ((len = fis.read(cbuf)) != -1) {
                String str = new String(cbuf, 0, len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) {
                    // 4.输入流关闭
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //实现对图片的复制操作
    @Test
    public void testFileInputStreamFileOutputStream() {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            //1. 创建File类对象,指明输出输入的文件
            File srcFile = new File("灯光.png");
            File goalFile = new File("灯光2.png");

            //2. 创建输出和出入流对象
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(goalFile);

            //3. 写入输出操作
            byte[] cbuf = new byte[5];
            int len;
            while ((len = fis.read(cbuf)) != -1) {
                fos.write(cbuf, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4. 流操作的关闭

            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //指定路径下文件的复制方法
    public void copyFile(String srcPath, String destPath) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            //1. 创建File类对象,指明输出输入的文件
            File srcFile = new File(srcPath);
            File goalFile = new File(destPath);

            //2. 创建输出和出入流对象
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(goalFile);

            //3. 写入输出操作
            byte[] cbuf = new byte[1024];
            int len;
            while ((len = fis.read(cbuf)) != -1) {
                fos.write(cbuf, 0, len);
//                bos.flush();//刷新缓冲区
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4. 流操作的关闭

            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testCopyFile() {
        long startTime = System.currentTimeMillis();
        String srcPath = "C:\\Users\\PePe\\Desktop\\不可仇恨 不可忘却2.0_1.mp4";
        String destPath = "C:\\Users\\PePe\\Desktop\\不可仇恨 不可忘却2.0_2.mp4";

//        String srcPath = "hello.txt";
//        String destPath = "hello3.txt";

        copyFile(srcPath, destPath);

        long endTime = System.currentTimeMillis();
        System.out.println("复制操作花费的时间为:" + (endTime - startTime));//2333
    }
}
