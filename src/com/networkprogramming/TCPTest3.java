package com.networkprogramming;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/*
实现TCP的网络编程
例题3: 从客户端发送文件给服务端,服务端保存到本地。
      并返回"发送成功"客户端。且关闭相应连接


      异常采用try-catch-finally接受
 */
public class TCPTest3 {

    //客户端
    @Test
    public void client() throws IOException {
        //1.
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 9909);
        //2.
        OutputStream os = socket.getOutputStream();
        //3.
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("滑稽.jpg"));
        //4.
        byte[] buffer = new byte[1024];
        int len;
        while ((len = bis.read(buffer)) != -1) {
            os.write(buffer, 0, len);
        }

        //关闭数据的输出
        socket.shutdownOutput();

        //5.
        InputStream is = socket.getInputStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer1 = new byte[20];
        int len1;
        while ((len1 = is.read(buffer1)) != -1) {
            baos.write(buffer1, 0, len1);
        }
        System.out.println(baos.toString());

        //6.
        baos.close();
        is.close();
        bis.close();
        os.close();
        socket.close();
    }

    //服务端
    @Test
    public void server() throws IOException {
        //1.
        ServerSocket socket = new ServerSocket(9909);
        //2.
        Socket accept = socket.accept();
        //3.
        InputStream is = accept.getInputStream();
        //4.
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("滑稽2.jpg"));
        //5.
        byte[] buffer = new byte[1024];
        int len;
        while ((len = is.read(buffer)) != -1) {
            bos.write(buffer, 0, len);
        }
        System.out.println("本地接受数据完成");

        //6.
        OutputStream os = accept.getOutputStream();
        os.write("文件已接受并保存".getBytes());
        //7.
        os.close();
        bos.close();
        is.close();
        accept.close();
        socket.close();
    }
}
