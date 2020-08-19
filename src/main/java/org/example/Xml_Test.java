package org.example;

import cn.hutool.core.util.XmlUtil;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import javax.xml.xpath.XPathConstants;

public class Xml_Test {
    public static void main(String[] args) {

        // 创建
        Document document = XmlUtil.createXml();

        // 读取
        Document docResult=XmlUtil.readXML("xml.xml");

        // xpath 获取
        Object value = XmlUtil.getByXPath("/returnsms/message", docResult, XPathConstants.STRING);
        System.out.println(value);



    }
}
