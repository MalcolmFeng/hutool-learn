package org.example;

import cn.hutool.core.io.resource.ClassPathResource;
import cn.hutool.core.util.URLUtil;

import java.net.URL;

public class URL_Test {
    public static void main(String[] args) {

        //获得ClassPath下资源的URL，方便读取Classpath下的配置文件等信息。
        URL url1 = URLUtil.getURL("application.properties");
        System.out.println(url1);


        String url2 = "http://www.hutool.cn//aaa/bbb";
        String normalize2 = URLUtil.normalize(url2);
        System.out.println(normalize2);

        String url3 = "http://www.hutool.cn//aaa/\\bbb?a=1&b=2";
        String normalize3 = URLUtil.normalize(url3);
        System.out.println(normalize3);
    }
}
