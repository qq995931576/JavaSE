package com.networkprogramming;

import java.net.MalformedURLException;
import java.net.URL;

/*
URL网络编程
    1. URL: 统一资源定位符，对应着互联网上的某一资源地址
    2. 格式:
        https://localhost:8080/examples/beauty.jpg?username=Tom
        协议:// 主机名(域名) :端口号 资源地址           参数列表
 */
public class URLTest {

    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.bilibili.com/video/BV1Kb411W75N?p=629");

//            public String getProtocol(  )     获取该URL的协议名
            System.out.println(url.getProtocol());//https

//            public String getHost(  )        获取该URL的主机名(域名)
            System.out.println(url.getHost());//www.bilibili.com

//            public String getPort(  )        获取该URL的端口号
            System.out.println(url.getPort());//-1

//            public String getPath(  )        获取该URL的文件路径
            System.out.println(url.getPath());///video/BV1Kb411W75N

//            public String getFile(  )         获取该URL的文件名
            System.out.println(url.getFile());///video/BV1Kb411W75N?p=629

//            public String getQuery(   )      获取该URL的查询名
            System.out.println(url.getQuery());//p=629

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
