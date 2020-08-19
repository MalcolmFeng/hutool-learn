package org.example;

import cn.hutool.core.util.StrUtil;

public class String_Test {
    public static void main(String[] args) {

        // 字符串为空判断
        String text = "abcdefg1234567@qq.com";
        System.out.println(StrUtil.isBlank(text));
        System.out.println(StrUtil.isEmpty(text));
        System.out.println(StrUtil.hasBlank("aaa","","xxx",null));
        System.out.println(StrUtil.hasEmpty("aaa","","xxx",null));

        // 字符串去除
        String front = StrUtil.removeSuffixIgnoreCase("http://www.baidu.com", ".com");
        String back = StrUtil.removePrefixIgnoreCase("http://www.baidu.com", "http://");
        System.out.println(front);
        System.out.println(back);

        // 字符串截取
        String str = "abcdefgh";
        String strSub1 = StrUtil.sub(str, 2, 3); //strSub1 -> c
        String strSub2 = StrUtil.sub(str, 2, -3); //strSub2 -> cde
        String strSub3 = StrUtil.sub(str, 3, 2); //strSub2 -> c

        // 字节数组
        StrUtil.bytes("xxx");

        // 格式化
        String template = "{}爱{}，就像老鼠爱大米";
        String format = StrUtil.format(template, "我", "你","x"); //str -> 我爱你，就像老鼠爱大米
        System.out.println(format);


    }
}
