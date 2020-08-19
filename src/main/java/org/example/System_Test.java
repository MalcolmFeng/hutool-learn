package org.example;

import cn.hutool.system.JavaRuntimeInfo;
import cn.hutool.system.SystemUtil;

public class System_Test {
    public static void main(String[] args) {
//        概述
//        此工具是针对System.getProperty(name)的封装，通过此工具，可以获取如下信息：

//        Java Virtual Machine Specification信息
        SystemUtil.getJvmSpecInfo();

//        Java Virtual Machine Implementation信息
        SystemUtil.getJvmInfo();

//        Java Specification信息
        SystemUtil.getJavaSpecInfo();

//        Java Implementation信息
        SystemUtil.getJavaInfo();

//                Java运行时信息
        JavaRuntimeInfo javaRuntimeInfo = SystemUtil.getJavaRuntimeInfo();
        System.out.println(javaRuntimeInfo.toString());

//                系统信息
        SystemUtil.getOsInfo();

//                用户信息
        SystemUtil.getUserInfo();

//                当前主机网络地址信息
        SystemUtil.getHostInfo();

//        运行时信息，包括内存总大小、已用大小、可用大小等
        SystemUtil.getRuntimeInfo();
    }
}
