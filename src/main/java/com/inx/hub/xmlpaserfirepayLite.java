package com.inx.hub;

/**
 * @Author huangjinping1000@163.com
 * @Description
 * @Date 4/29/22
 **/


import org.dom4j.*;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.dom4j.xpath.DefaultXPath;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class xmlpaserfirepayLite {

    private static final String unit = "east_t_";

    public static void main(String[] args) {


       StringBuilder builder=new StringBuilder();
        builder.append("key").append("value");
        builder.toString();
        System.out.println(builder);

        try {
            System.out.println("000000000");
            System.out.println(AESUtil.encrypt("123456", "102bc561993b941dc44f971b2412f9e8"));
            System.out.println("11111111");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }







}
