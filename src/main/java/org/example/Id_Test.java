package org.example;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;

public class Id_Test {
    public static void main(String[] args) {

        // 生成的UUID是带-的字符串，类似于：a5c8a5e8-df2b-4706-bea4-08d0939410e3
        String uuid = IdUtil.randomUUID();

        // 生成的是不带-的字符串，类似于：b17f24ff026d40949c85a24f4f375d42
        String simpleUUID = IdUtil.simpleUUID();

        // Snowflake
        //参数1为终端ID
        //参数2为数据中心ID
        Snowflake snowflake = IdUtil.getSnowflake(1, 1);
        long id = snowflake.nextId();
        long id1 = snowflake.nextId();
        long id2 = snowflake.nextId();
        long id3 = snowflake.nextId();
        long id4 = snowflake.nextId();

        System.out.println(id + "-" +id1+ "-" +id2+ "-" +id3+ "-" +id4);
        //注意 IdUtil.createSnowflake每次调用会创建一个新的Snowflake对象，不同的Snowflake对象创建的ID可能会有重复，因此请自行维护此对象为单例，或者使用IdUtil.getSnowflake使用全局单例对象。
    }
}
