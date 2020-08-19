package org.example;

import cn.hutool.core.util.EscapeUtil;

public class Escape_Test {
    public static void main(String[] args) {

        // 此类中的方法对应Javascript中的escape()函数和unescape()函数。
        System.out.println(EscapeUtil.escape("http://localhost:9090/something#abc?aaa=111&bbb=222"));
    }
}
