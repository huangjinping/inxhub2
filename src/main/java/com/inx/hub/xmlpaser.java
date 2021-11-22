package com.inx.hub;

import org.dom4j.*;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.dom4j.xpath.DefaultXPath;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class xmlpaser {

    private static final String unit = "";

    public static void main(String[] args) {
        System.out.println("--------cb39f8d3f33623ce3386eeb907c1c8f8-");
//        e4bc2a19ff4fba5db96b80be17791e54

        try {
            List<Map<String, String>> strings = parseMethod1();
            generate(strings, "xml/stringsResult.xml", "e4bc2a19ff4fba5db96b80be17791e54");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static List<Map<String, String>> parseMethod1() throws DocumentException {
        List<Map<String, String>> result = new ArrayList<Map<String, String>>();

        SAXReader reader = new SAXReader();
        Document document = reader.read("xml/strings.xml");
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
                    product.setText(unit + AESUtil.encrypt(entry.getValue(), key));
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
