package com.iostream.java;

import com.oop.demo05.B;
import org.junit.Test;

import java.io.*;

/*
    一. 流的分类
        1. 操作数据单位: 字节流、字符流
        2. 数据的流向: 输入流、输出流
        3. 流的角色: 节点流、处理流

    二. 流的体系结构
        抽象基类                节点流 (或文件流)                              缓冲流 (处理流的一种)
        InputStream             FileInputStream (read(byte[] buffer))          BufferedInputStream (read(byte[] buffer))
        OutputStream            FileOutputStream (write(cbuf,0,len))           BufferedOutputStream (write(cbuf,0,len)) / flush()
        Reader                  FileReader(read(char[] cbuf))                  BufferedReader (read(char[] cbuf) / readline())
        Writer                  FileWriter(write(cbuf,0,len))                  BufferedWriter (write(cbuf,0,len)) / flush()

 */
public class FileReaderWriterTest {
    public static void main(String[] args) {
        File file = new File("hello.txt");//相较于当前工程
        System.out.println(file.getAbsolutePath());
    }
    /*
    将Note下的hello.txt文件内容读入程序中，并输出到控制台

    说明:
    1. read()的理解: 返回读入的一个字符。如果达到文件末尾，返回 -1。
    2. 异常的处理: 为了保证 流 资源一定可以执行关闭操作。需要使用try-catch-finally处理
    3. 读入的文件一定要存在,否则就会报FileNotFoundException。

     */

    @Test
    public void testFileReader() {
        FileReader fr = null;
        try {
            //1. 实例化File类的对象,指明要操作的文件
            File file = new File("hello.txt");//相较于当前Module
            //2. 提供具体的流
            fr = new FileReader(file);

            //3. 数据的读入
            //read(): 返回一个读入的字符。如果达到文件末尾，返回 -1

            //方式一:
//        int date = fr.read();
//        while(date != -1){
//            System.out.print((char)date);
//            date = fr.read();
//        }
            //方式二: 语法上针对于方式一的修改
            int date;
            while ((date = fr.read()) != -1) {
                System.out.print((char) date);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4. 流的关闭
            try {
                if (fr != null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    //对read()的操作升级: 使用read()的重载方法
    @Test
    public void testFileReader1() {
        FileReader fr = null;
        try {
            //1. File类的实例化
            File file = new File("hello.txt");

            //2. FileReader流的实例化
            fr = new FileReader(file);
            //3. 读入的操作
            //read(char[] cbuf,):返回每次读入cbuf数组中的字符的个数。如果达到文件末尾,返回 -1。
            char[] cbuf = new char[5];
            int len;
            while ((len = fr.read(cbuf)) != -1) {
                //方式一:

                //错误写法:
//                for (int i = 0; i < cbuf.length; i++) {
//                    System.out.print(cbuf[i]);
//                }
                //正确写法:
//                for (int i = 0; i < len; i++) {
//                    System.out.print(cbuf[i]);
//                }

                //方式二:
                //错误写法:
//                String s = new String(cbuf);
//                System.out.println(s);
                //正确写法:
                String s = new String(cbuf, 0, len);
                System.out.print(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fr != null) {
                    //4. 资源关闭
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /*
    从内存中写出数据到硬盘文件里。

    说明:
        1. 输出操作,对应的File可以不存在。并不会报异常。
        2.    File对应硬盘中的文件,如果不存在，在输出的过程中会自动创建此文件。
              File对应硬盘中的文件,如果存在:
                    如果流使用的构造器是:FileWriter(file,false) / FileWriter(file): 对原有文件的覆盖
                    如果流使用的构造器是:FileWriter(file,true): 不会对原有文件覆盖，而是在原有文件基础上追加内容

     */
    @Test
    public void testFileWriter() {
        FileWriter fw = null;
        try {
            //1. 提供File类的对象，指明写出到的文件
            File file = new File("hello1.txt");

            //2. 提供FileWriter的对象，用于数据的写出
            fw = new FileWriter(file, false);

            //3. 写出的操作
            fw.write("i have a dream!\n");
            fw.write("you need to have a dream!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fw != null) {
                    //4. 流资源的关闭
                    fw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testFileWriterFileReader() {
        FileReader fr = null;
        FileWriter fw = null;
        try {
            //1. 创建File类的对象,指明读入和写入的文件
            File srcFile = new File("hello.txt");
            File destFile = new File("hello2");

            //不能使用字符流来处理图片等字节数据
//            File srcFile = new File("灯光.png");
//            File destFile = new File("灯光1.png");

            //2. 创建输入流和输出流对象
            fr = new FileReader(srcFile);
            fw = new FileWriter(destFile);

            //3. 数据的读入和写出操作
            char[] cbuf = new char[5];
            int len;//记录每次读入到cbuf数组中的字符个数
            while ((len = fr.read(cbuf)) != -1) {
                fw.write(cbuf, 0, len);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4. 关闭流资源
            //方式一:
//            try {
//                if (fw !=null){
//                    fw.close();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            finally{
//                try {
//                    if (fr !=null){
//                        fr.close();
//                    }
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
            //方式二
            try {
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
