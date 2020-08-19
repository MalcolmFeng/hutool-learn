package org.example;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.ZipUtil;

import java.io.File;

public class Zip_Test {
    public static void main(String[] args) {

        //将aaa目录下的所有文件目录打包到d:/aaa.zip
        ZipUtil.zip("d:/aaa");

        //将aaa目录下的所有文件目录打包到d:/bbb/目录下的ccc.zip文件中
        ZipUtil.zip("d:/aaa", "d:/bbb/ccc.zip");

        // 是否包含根目录
        ZipUtil.zip("d:/aaa", "d:/bbb/ccc.zip", true);

        // 多文件或目录压缩
        ZipUtil.zip(FileUtil.file("d:/bbb/ccc.zip"), false,
                FileUtil.file("d:/test1/file1.txt"),
                FileUtil.file("d:/test1/file2.txt"),
                FileUtil.file("d:/test2/file1.txt"),
                FileUtil.file("d:/test2/file2.txt")
        );



        // 将test.zip解压到e:\\aaa目录下，返回解压到的目录
        File unzip = ZipUtil.unzip("E:\\aaa\\test.zip", "e:\\aaa");




    }
}
