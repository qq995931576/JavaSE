package com.iostream.java;

/*
处理流之一: 缓冲流的使用

1. 缓冲流:
BufferedInputStream
BufferedOutputStream
BufferedReader
BufferedWriter

2. 作用:
       提供流的读取、写入速度
       提高读写速度的原因:
                        内部提供了一个缓冲区

3. 处理流,就是"套接"在已有的流基础上。
 */

import org.junit.Test;

import java.io.*;

public class BufferdTest {

    //实现非文本文件的复制
    @Test
    public void BufferedInputStreamTest() {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            //1. File类的文件创建
            File srcFile = new File("灯光.png");
            File destFile = new File("灯光3.png");

            //2. 流文件对象的创建
            //2.1 两个节点流(文件流)
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);
            //2.2 两个缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);


            //3. 复制操作: 读取、写入
            byte[] buffer = new byte[10];
            int len;
            while ((len = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
//                bos.flush();//刷新缓冲区
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4. 流的关闭
            //要求4.1: 先关闭外层的流,再关闭内层的流
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bis != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            //说明: 关闭外层流的同时,内层流也会自动的关闭。关于内层流的关闭操作,可以省略。
//            fis.close();
//            fos.close();
        }
    }


    //实现文件复制的方法
    public void copyFileBuffered(String srcPath, String destPath) {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            //1. 创建File类的对象
            File srcFile = new File(srcPath);
            File destFile = new File(destPath);

            //2. 创建流对象
            //2.1 节点流的创建
            FileInputStream fis = new FileInputStream(srcFile);
            FileOutputStream fos = new FileOutputStream(destFile);

            //2.2 处理流:缓冲流的创建
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            //3. 复制操作: 数据的读出与写入
            byte[] buffer = new byte[1024];
            int len;
            while ((len = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4. 流的关闭
            try {
                if (bos != null) {
                    bos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bos != null) {
                    bis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            //说明: 关闭外层流的同时,内层流也会自动的关闭。关于内层流的关闭操作,可以省略。
//            fis.close();
//            fos.close();
        }
    }

    //复制方法的测试
    @Test
    public void testCopyFileBuffered() {
        long startTime = System.currentTimeMillis();
        String srcPath = "C:\\Users\\PePe\\Desktop\\不可仇恨 不可忘却2.0_1.mp4";
        String destPath = "C:\\Users\\PePe\\Desktop\\不可仇恨 不可忘却2.0_3.mp4";
        copyFileBuffered(srcPath, destPath);
        long endTime = System.currentTimeMillis();
        System.out.println("复制操作花费的时间为:" + (endTime - startTime));//1080
    }


    //使用BufferedReader和BufferedWriter实现文本文件的复制
    @Test
    public void testBufferedReaderBufferedWriter() {
        //创建File类文件和对应流文件
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new FileReader(new File("消息信息.txt")));
            bw = new BufferedWriter(new FileWriter(new File("消息信息1.txt")));

            //复制操作
            //方式一: 使用char[]
//            char[] buffer = new char[10];
//            int len;
//            while ((len = br.read(buffer))!=-1){
//                bw.write(buffer,0,len);
//            }

            //方式二: 使用String
            String date;
            while ((date = br.readLine()) != null) {
                //方法一:
//                bw.write(date+"\n");//date中不包含换行符
                //方法二:
                bw.write(date);//date中不包含换行符
                bw.newLine();//提供换行操作
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流资源
            try {
                if (bw != null) {
                    bw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
