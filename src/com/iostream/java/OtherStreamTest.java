package com.iostream.java;

import org.junit.Test;

import java.io.*;
import java.io.InputStreamReader;

/*
其他流的使用
    1. 标准的输入、输出流
    2. 打印流
    3. 数据流
 */
public class OtherStreamTest {

    /*
    1. 标准的输入、输出流
        1.1
        System.in: 标准的输入流,默认从键盘输入
        System.out: 标准的输出流,默认从控制台输出
        1.2
        System类的setIn(InputStream is) / setOut(PrintStream ps)方式重新指定输入输出的流。
        1.3练习:
        从键盘输入字符串,要求将读取到的整行字符串转成大写输出。然后继续进行输入操作,直到当输入"e"或者"exit"时,退出程序。

        方法一: 使用Scanner实现,调用next()返回一个字符串
        方法二: 使用System.in实现。 System.in  --->  转换流  ---> BufferedReader的readline()


     */
    public static void main(String[] args) {
        BufferedReader br = null;
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            br = new BufferedReader(isr);

            while (true) {
                System.out.println("请输入字符串:");
                String str = br.readLine();
                if ("e".equalsIgnoreCase(str) || "exit".equalsIgnoreCase(str)) {
                    System.out.println("系统退出");
                    System.exit(0);
                } else {
                    String s = str.toUpperCase();
                    System.out.println(s);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /*
    2. 打印流: PrintStream和PrintWriter

    2.1 提供了一系列重载的print() 和 println()

     */

    @Test
    public void test2() {
        PrintStream ps = null;
        try {
            FileOutputStream fos = new FileOutputStream(new File("D:\\test\\test3.txt"));

            //创建打印输出流,设置为自动刷新模式(写入换行符或字符 '\n'时都会刷新输出缓冲区)
            ps = new PrintStream(fos, true);
            if (ps != null) {//把标准输出流(控制台输出)改成文件
                System.setOut(ps);
            }
            for (int i = 0; i < 255; i++) {//输出ASCII字符
                System.out.print((char) i);
                if (i % 5 == 0) {//每50个数据一行
                    System.out.println();
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
    }

    /*
    3. 数据流
    3.1 DateInputStream 和 DateOutputStream
    3.2 用于读取或写出基本数据类型的变量或字符串

    练习: 将内存中的字符串、基本数据类型的变量写出到文件中。


     */

    //数据写入
    @Test
    public void test3() {
        //1.
        DataOutputStream dos = null;
        try {
            dos = new DataOutputStream(new FileOutputStream("date.txt"));
            //2.
            dos.writeUTF("阿昌");
            dos.flush();//刷新操作,将内存中的数据写入文件
            dos.writeInt(21);
            dos.flush();
            dos.writeBoolean(true);
            dos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //3.
            if (dos != null) {
                try {
                    dos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /*
    将文件中存储的基本数据类型和字符串读取到内存中,保存在变量中。

    注意点:读取不同类型数据的顺序要按照当初写入的顺序保持一致。

     */

    //数据读取
    @Test
    public void test4() {
        DataInputStream dis = null;
        try {
            //1.
            dis = new DataInputStream(new FileInputStream("date.txt"));
            //2.
            String name = dis.readUTF();
            int age = dis.readInt();
            boolean isMale = dis.readBoolean();

            System.out.println("name=" + name);
            System.out.println("age=" + age);
            System.out.println("isMale=" + isMale);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (dis != null) {
                //3.
                try {
                    dis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}