package com.inx.hub;

/**
 * @Author huangjinping1000@163.com
 * @Description
 * @Date 4/29/22
 **/


import com.inx.hub.bean.DocUtils;
import org.dom4j.*;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.dom4j.xpath.DefaultXPath;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class xmlpaserre {

    private static final String unit = "xxxxxxxxxxxxxxxxxxxmmmmmmmmm";

    public static void main(String[] args) {

        try {
            List<Map<String, String>> strings = parseMethod1();
            generate(strings, "xml/stringsResult.xml", "57b5bd27532a4e9bb4f7897ce33539a3");



        } catch (Exception e) {
            e.printStackTrace();
        }


        final int code[] = {203, 7717, 56, 2031, 7678000};
        final int current[] = {193, 6911, 18, 40, 6626763};


//        System.out.println(unit + AESUtil.encrypt(value, "776c4d7810111d848e6bd0393060c80a"));
        System.out.println("-----222-------");

        try {
            System.out.println("000000000");
//            System.out.println(AESUtil.decrypt(sorce, "776c4d7810111d848e6bd0393060c80a"));
            System.out.println("11111111");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    private static int compareIdeaVersion(int code[], int current[]) {
        boolean equals = Arrays.equals(code, current);
        if (equals) {
            return 0;
        }
        for (int i = 0; i < code.length; i++) {
            if (current[i] > code[i]) {
                return 1;
            }
        }

        return -1;
    }


    final static String tag = "EAST";

    private static String renameClass(String source, String tag) {
        StringBuffer stringBuffer = new StringBuffer(source);
        try {
            stringBuffer.insert(DocUtils.getRandomInt(source.length()), tag);
            int randomInt = DocUtils.getRandomInt(source.length());
            if (randomInt > 0) {
                stringBuffer.insert(randomInt, DocUtils.getRandomString(18));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stringBuffer.toString();
    }


    public static List<Map<String, String>> parseMethod1() throws DocumentException {
        List<Map<String, String>> result = new ArrayList<Map<String, String>>();

        SAXReader reader = new SAXReader();
        Document document = reader.read("xml/string2.xml");
        XPath xPath = new DefaultXPath("/resources/string");
        List<Element> list = xPath.selectNodes(document.getRootElement());
        for (Element element : list) {
            System.out.println(element.attributeValue("name") + "======" + element.getTextTrim());
//            result.add(element.getTextTrim());
            Map<String, String> map = new HashMap<>();
            map.put(element.attributeValue("name"), element.getTextTrim());
            result.add(map);
        }
        return result;
    }


    public static String fileterValue(String value) {
        value = value.replace("\\n", "$*").replace("\\t", "$#");
        return value;
    }


    public static String reverseValue(String value) {
        StringBuffer buffer = new StringBuffer();
        buffer.append(value);
        return buffer.reverse().toString();
    }


    public static String insert(String value) {
        String result = "";
        StringBuffer buffer = new StringBuffer(value);

        result = unit + value;

        return result;
    }

    public static void generate2(List<Map<String, String>> source, String fileName, String key) throws Exception {
        Document doc = DocumentHelper.createDocument();
        Element root = doc.addElement("resources");
        for (Map<String, String> map : source
        ) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                Element product = root.addElement("string");
                product.addAttribute("name", entry.getKey());
                String value = entry.getValue();
                if (value.contains("%s")) {
                    product.setText(value);
                } else {


                    try {
                        String replace = entry.getValue().replaceAll(unit, "");
                        product.setText(AESUtil.decrypt(fileterValue(replace), key));
                    } catch (Exception e) {
                        e.printStackTrace();
                        product.setText(fileterValue(entry.getValue()));

                    }

                }
            }
        }

        PrintWriter pWriter = null;
        XMLWriter xWriter = null;
        try {
            pWriter = new PrintWriter(fileName);
            xWriter = new XMLWriter(pWriter);
            xWriter.write(doc);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                xWriter.flush();
                xWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void generate(List<Map<String, String>> source, String fileName, String key) {
        Document doc = DocumentHelper.createDocument();
        Element root = doc.addElement("resources");
        for (Map<String, String> map : source
        ) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                Element product = root.addElement("string");
                product.addAttribute("name", entry.getKey());
                String value = entry.getValue();
                if (value.contains("%s")) {
                    product.setText(value);
                } else {
                    product.setText(AESUtil.encrypt(fileterValue(entry.getValue()), key));
//                    product.setText(unit + insert(entry.getValue()));

                }
            }
        }

        PrintWriter pWriter = null;
        XMLWriter xWriter = null;
        try {
            pWriter = new PrintWriter(fileName);
            xWriter = new XMLWriter(pWriter);
            xWriter.write(doc);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                xWriter.flush();
                xWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
