package org.example;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.file.FileAppender;
import cn.hutool.core.io.file.FileReader;
import cn.hutool.core.io.file.FileWriter;
import cn.hutool.core.io.resource.ClassPathResource;
import cn.hutool.core.io.resource.ResourceUtil;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class IO_Test {
    public static void main(String[] args) throws IOException {
        // 1、mkdir （创建目录）
        FileUtil.mkdir("C:\\Users\\fengdianlong\\Desktop\\xxx");

        // 2、touch （创建文件）
        File touchtxt = FileUtil.touch(new File("C:\\Users\\fengdianlong\\Desktop\\xxx\\touch.txt"));

        // 2.1、文件写入
        FileWriter writer = new FileWriter(touchtxt);
        writer.write("touch");

        // 2.2、文件读取
        FileReader reader = new FileReader(touchtxt);
        reader.readString();

        // 2.3、文件追加
        FileAppender appender = new FileAppender(touchtxt, 16, true);
        appender.append("123");
        appender.append("abc");
        appender.append("xyz");
        appender.flush();
        appender.toString();

        // 3、ls （列出目录）
        File[] files = FileUtil.ls("C:\\Users\\fengdianlong\\Desktop\\xxx");
        for (int i = 0; i < files.length; i++) {
            System.out.println(files[i].getName());
        }

        // 4、del (删除目录，删除文件)；
//        FileUtil.del("C:\\Users\\fengdianlong\\Desktop\\xxx");
//        FileUtil.del("C:\\Users\\fengdianlong\\Desktop\\xxx\\touch.txt");

        // 5、cp (文件复制)
        FileUtil.copy("C:\\Users\\fengdianlong\\Desktop\\xxx\\touch.txt","C:\\Users\\fengdianlong\\Desktop\\xxx\\cp.txt",true);




        // 资源文件的读取
        String resource = ResourceUtil.readUtf8Str("application.properties");
        System.out.println(resource);




        // 配置文件的读取
        ClassPathResource classPathResource = new ClassPathResource("application.properties");
        Properties properties = new Properties();
        properties.load(classPathResource.getStream());
        String port = properties.getProperty("port");
        System.out.println(port);

    }
}
