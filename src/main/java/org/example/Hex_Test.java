package org.example;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.HexUtil;

public class Hex_Test {
    public static void main(String[] args) {

        String str = "我是一个字符串";

        String hex = HexUtil.encodeHexStr(str, CharsetUtil.CHARSET_UTF_8);
        System.out.println(hex);  // hex是：e68891e698afe4b880e4b8aae5ad97e7aca6e4b8b2

        String decodedStr = HexUtil.decodeHexStr(hex);
        System.out.println(decodedStr);

    }
}
