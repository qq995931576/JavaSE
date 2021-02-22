package com.networkprogramming;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/*
实现TCP的网络编程
例题2: 客户端发送文件给服务端,服务端将文件保存在本地。
 */
public class TCPTest2 {

    //客户端
    @Test
    public void client() {
        Socket socket = null;
        OutputStream os = null;
        BufferedInputStream bis = null;
        try {
            //1. 创建一个Socket对象,指明服务器端的IP和端口号
            InetAddress inet1 = InetAddress.getByName("127.0.0.1");
            socket = new Socket(inet1, 8899);
            //2. 创建输出流,用于输出数据
            os = socket.getOutputStream();
            //3. 创建要输入发送的文件
            bis = new BufferedInputStream(new FileInputStream("滑稽.jpg"));
            //4. 发送操作
            byte[] buffer = new byte[1024];
            int len;
            while ((len = bis.read(buffer)) != -1) {
                os.write(buffer, 0, len);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //5. 流资源的关闭
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    //服务端
    @Test
    public void server() {
        ServerSocket ss = null;
        Socket socket = null;
        InputStream is = null;
        BufferedOutputStream bos = null;
        try {
            //1. 创建服务器端的ServerSocket,指明自己的端口号
            ss = new ServerSocket(8899);
            //2. 调用accept() 表示接受来自客服端的socket
            socket = ss.accept();
            //3. 获取一个输入流
            is = socket.getInputStream();
            //4. 创建一个保存本地的输出流
            bos = new BufferedOutputStream(new FileOutputStream("滑稽1.jpg"));
            //5. 保存本地的操作
            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            }
            System.out.println("接收成功");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //6. 资源的关闭
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (ss != null) {
                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
