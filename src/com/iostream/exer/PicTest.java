package com.iostream.exer;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class PicTest {

    //图片的加密操作
    @Test
    public void test1() {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            //File类对象的创建和流的创建
            fis = new FileInputStream("灯光.png");
            fos = new FileOutputStream("灯光4scret.png");
            //加密操作
            byte[] cbuf = new byte[20];
            int len;
            while ((len = fis.read(cbuf)) != -1) {
                //字节数组进行修改
                //错误的
                //            for (byte b:cbuf){
                //               b = (byte) (b^5);
                //            }
                //正确的
                for (int i = 0; i < len; i++) {
                    cbuf[i] = (byte) (cbuf[i] ^ 5);
                }
                fos.write(cbuf, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //流资源的关闭
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

    //图片的解密操作
    @Test
    public void test2() {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            //File类对象的创建和流的创建
            fis = new FileInputStream("灯光4scret.png");
            fos = new FileOutputStream("灯光5decrypt.png");
            //加密操作
            byte[] cbuf = new byte[20];
            int len;
            while ((len = fis.read(cbuf)) != -1) {
                //字节数组进行修改
                //错误的
                //            for (byte b:cbuf){
                //               b = (byte) (b^5);
                //            }
                //正确的
                for (int i = 0; i < len; i++) {
                    cbuf[i] = (byte) (cbuf[i] ^ 5);
                }
                fos.write(cbuf, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //流资源的关闭
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
}
