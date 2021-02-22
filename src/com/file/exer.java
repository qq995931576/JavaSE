package com.file;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class exer {
    @Test
    public void test() throws IOException {
        File file = new File("D:\\test\\text.txt");
        //创建一个与file同目录下的另一个文件,文件名为: haha.txt
        File file1 = new File("D:\\test\\haha.txt");
        boolean newFile = file1.createNewFile();
        if (newFile) {
            System.out.println("创建成功");
        }

    }

    @Test
    public void test1() {
        File file = new File("D:\\test");
        if (file.isDirectory()) {
            String[] list = file.list();
            for (String s : list) {
                if (s.endsWith(".jpg")) {
                    System.out.println(s);
                }
            }
        }
    }

}
