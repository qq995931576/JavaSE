package com.collection.java1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Properties;

public class PropertiesTest {
    //Properties: 常用来处理配置文件; key和value都是String类型
    public static void main(String[] args) {
        FileInputStream fis = null;
        try {
            Properties pros = new Properties();
            fis = new FileInputStream("jdbc.properties");
            pros.load(fis);//加载流对应的文件

            String name = pros.getProperty("name");
            String password = pros.getProperty("password");

            System.out.println("name =" + name + "，password =" + password);//name =PePe郑彦昌，password =16839886
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
            }
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
