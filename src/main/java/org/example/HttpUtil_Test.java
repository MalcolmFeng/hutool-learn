package org.example;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.StreamProgress;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;

import java.util.HashMap;

public class HttpUtil_Test {
    public static void main(String[] args) {


        //链式构建请求
        HttpResponse res = HttpRequest.post("url")
                .header(Header.USER_AGENT, "Hutool http")//头信息，多个头信息多次调用此方法即可
                .form(new HashMap<>())//表单内容
                .timeout(20000)//超时，毫秒
                .execute();

        System.out.println(res.getStatus());
        System.out.println(res.headers());
        System.out.println(res.getCookies());
        System.out.println(res.body());



        System.out.println("--- 以下为HttpUtil，即对HttpRequest和HttpResponse的封装！");



        System.out.println("--- GET ---");
        // 最简单的HTTP请求，可以自动通过header等信息判断编码，不区分HTTP和HTTPS
        String result1= HttpUtil.get("https://www.baidu.com");

        // 当无法识别页面编码的时候，可以自定义请求页面的编码
        String result2= HttpUtil.get("https://www.baidu.com", CharsetUtil.CHARSET_UTF_8);

        //可以单独传入http参数，这样参数会自动做URL编码，拼接在URL中
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("city", "北京");
        String result3= HttpUtil.get("https://www.baidu.com", paramMap);




        System.out.println("--- POST ---");
        HashMap<String, Object> paramMap2 = new HashMap<>();
        paramMap2.put("city", "北京");
        String result= HttpUtil.post("https://www.baidu.com", paramMap2);




        System.out.println("--- 文件上传 ---");
        HashMap<String, Object> paramMap5 = new HashMap<>();
        //文件上传只需将参数中的键指定（默认file），值设为文件对象即可，对于使用者来说，文件上传与普通表单提交并无区别
        paramMap5.put("file", FileUtil.file("D:\\face.jpg"));
        String result5 = HttpUtil.post("https://www.baidu.com", paramMap5);




        System.out.println("--- 文件下载 ---");
        String fileUrl = "http://mirrors.sohu.com/centos/7.3.1611/isos/x86_64/CentOS-7-x86_64-DVD-1611.iso";
        //将文件下载后保存在E盘，返回结果为下载文件大小
        long size = HttpUtil.downloadFile(fileUrl, FileUtil.file("e:/"));
        System.out.println("Download size: " + size);




        System.out.println("--- 带进度显示的文件下载 ---");
        HttpUtil.downloadFile(fileUrl, FileUtil.file("e:/"), new StreamProgress(){
            @Override
            public void start() {
                System.out.println("开始下载。。。。");
            }
            @Override
            public void progress(long progressSize) {
                System.out.println(StrUtil.format("已下载：{}", progressSize));
            }
            @Override
            public void finish() {
                System.out.println("下载完成！");
            }
        });





    }
}
