package com.iostream.exer;

import org.junit.Test;

import java.io.*;

public class exer1 {
    /*
    1.  分别使用节点流: FileInputStream、FileOutputStream和
        缓冲流:BufferedInputStream、BufferedOutputStream实现文本文件/图片/视频文件的复制。并比较二者在数据复制方面的效率
     */

    //BufferedInOutputStream复制方法
    public void copyBufferedInOutputStream(String srcPath, String destPath) {
        BufferedOutputStream bos = null;
        BufferedInputStream bis = null;
        try {
            //建立File类对象和流对象
            bos = new BufferedOutputStream(new FileOutputStream(new File(destPath)));
            bis = new BufferedInputStream(new FileInputStream(new File(srcPath)));

            //复制操作
            byte[] buffer = new byte[1024];
            int len;
            while ((len = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //流资源关闭
            try {
                if (bis != null) {
                    bis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bos != null) {
                    bos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //FileInOutputStream复制方法
    public void copyFileInoutputStream(String srcPath, String destPath) {
        FileOutputStream fos = null;
        FileInputStream fis = null;
        try {
            //创建File类对象与流对象
            fos = new FileOutputStream(new File(destPath));
            fis = new FileInputStream(new File(srcPath));
            //复制操作
            byte[] buffer = new byte[1024];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //流资源关闭
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //测试BufferedInOutputStream效率
    @Test
    public void testBufferedInOutputStream() {
        Long startTime = System.currentTimeMillis();
        String srcPath = "C:\\Users\\PePe\\Desktop\\不可仇恨 不可忘却2.0_1.mp4";
        String destPath = "C:\\Users\\PePe\\Desktop\\不可仇恨 不可忘却2.0_2.mp4";
        copyBufferedInOutputStream(srcPath, destPath);
        Long endTime = System.currentTimeMillis();

        System.out.println("复制花费时间:" + (endTime - startTime));//1182
    }

    //测试FileInOutputStream效率
    @Test
    public void testFileInOutputStream() {
        Long startTime = System.currentTimeMillis();
        String srcPath = "C:\\Users\\PePe\\Desktop\\不可仇恨 不可忘却2.0_1.mp4";
        String destPath = "C:\\Users\\PePe\\Desktop\\不可仇恨 不可忘却2.0_3.mp4";
        copyFileInoutputStream(srcPath, destPath);
        Long endTime = System.currentTimeMillis();

        System.out.println("复制花费时间:" + (endTime - startTime));//2516
    }
}
