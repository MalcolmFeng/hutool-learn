package org.example;

import cn.hutool.core.date.*;

import java.util.Date;

/**
 * Hello world!
 *
 */
public class DateTime_Test {
    public static void main( String[] args ) throws InterruptedException {
        System.out.println("--- 时间对象 ---");
        DateTime dateTime1 = DateUtil.date();
        DateTime dateTime2 = DateUtil.dateSecond();
        System.out.println(dateTime1);
        System.out.println(dateTime2);

        System.out.println("--- 字符串 ---");
        String today = DateUtil.today();
        String now= DateUtil.now();
        System.out.println(today);
        System.out.println(now);

        System.out.println("--- 格式转换 ---");
        DateTime parse1 = DateUtil.parse("2017-03-01");
        String format1 = DateUtil.format(dateTime1,"yyyyMM");
        String format2 = DateUtil.formatDate(dateTime1);
        String format3 = DateUtil.formatTime(dateTime1);
        System.out.println(parse1);
        System.out.println(format1);
        System.out.println(format2);
        System.out.println(format3);

        System.out.println("--- 格式化时间差 ---");
        String between = DateUtil.formatBetween(1000000000, BetweenFormater.Level.MINUTE);
        String between2 = DateUtil.formatBetween(DateUtil.parse("2020-08-20"),DateUtil.parse("2020-08-23"), BetweenFormater.Level.MINUTE);
        System.out.println(between);
        System.out.println(between2);

        System.out.println("--- 计时器 ---");
        TimeInterval interval = DateUtil.timer();
        Thread.sleep(1000);
        System.out.println(interval.interval());
        Thread.sleep(1000);
        System.out.println(interval.intervalRestart());
        Thread.sleep(1000);
        System.out.println(interval.intervalSecond());

        System.out.println("--- 年龄 ---");
        int age = DateUtil.ageOfNow("1992-08-27");
        System.out.println(age);

        System.out.println("--- 时间偏移 ---");
        DateTime offset = dateTime1.offset(DateField.YEAR,-1);


    }
}
