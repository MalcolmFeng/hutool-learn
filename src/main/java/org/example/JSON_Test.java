package org.example;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

public class JSON_Test {
    public static void main(String[] args) {
        JSONObject json1 = JSONUtil.createObj()
                .put("a", "value1")
                .put("b", "value2")
                .put("c", "value3");

        System.out.println("--- 转换 ---");
        String jsonStr = "{\"b\":\"value2\",\"c\":\"value3\",\"a\":\"value1\"}";
        //方法一：使用工具类转换
        JSONObject jsonObject = JSONUtil.parseObj(jsonStr);
        //方法二：new的方式转换
        JSONObject jsonObject2 = new JSONObject(jsonStr);

        JSONObject json = JSONUtil.parseObj(new Object(), false);
        System.out.println(json.toStringPretty());


        System.out.println("--- jsonarray ---");

        //方法1
        JSONArray array = JSONUtil.createArray();
        //方法2
        JSONArray array2 = new JSONArray();

        array.add("value1");
        array.add("value2");
        array.add("value3");

        //转为JSONArray字符串
        array.toString();

        String jsonStr2 = "[\"value1\", \"value2\", \"value3\"]";
        JSONArray array3 = JSONUtil.parseArray(jsonStr2);

    }
}
