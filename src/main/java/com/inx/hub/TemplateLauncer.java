package com.inx.hub;

import com.inx.hub.bean.DocUtils;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.Version;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class TemplateLauncer {

    public static void main(String[] args) {


//        demo1();
//        demo2();


//        String[] arrlist = {"FrameLayout.ftl", "Layout1.ftl", "RelativeLayout1.ftl", "TextView.ftl"};
//        for (int i = 0; i < 100; i++) {
//            int anInt = DocUtils.getRandomInt(arrlist.length);
//            createTemplate(arrlist[anInt], "template/res/resLayout" + i + "");
//        }
//        String[] arrJavalist = {"java1.ftl", "java2.ftl", "java3.ftl", "java4.ftl", "java5.ftl"};
//        for (int i = 0; i < 100; i++) {
//            int anInt = DocUtils.getRandomInt(arrJavalist.length);
//            createJavaTemplate(arrJavalist[anInt], "template/java/javaCode" + i + "");
//        }

//        String[] array = DocUtils.getArray();
//        Gson gson = new Gson();
//        FileUtils.witermessage(gson.toJson(array), "template/result.json");


//        String[] arrJavalist = {"kotlin.ftl", "kotlin.ftl", "kotlin.ftl", "kotlin.ftl", "kotlin.ftl"};
        String[] arrJavalist = {"kotlin4.ftl"};
        for (int i = 0; i < 100; i++) {
            int anInt = DocUtils.getRandomInt(arrJavalist.length);
            createJavaTemplate(arrJavalist[anInt], "template/kotlin/kotlin" + i + "");
        }

    }


    public static void createJavaTemplate(String temp, String pathName) {
        try {

            Template template = getConfiguration().getTemplate("ftl/" + temp);

            Map paramter = getJavaParamter();
//            Writer out = new FileWriter(new File("template/TextView.text"));
            Writer out = new FileWriter(new File(pathName));
            //8.生成静态文件
            template.process(paramter, out);
            //9.关闭流
            out.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Map getJavaParamter() {
        Map map = new HashMap();
        map.put("name", DocUtils.getRadomWord());
        map.put("name0", DocUtils.getRadomWord());
        map.put("name1", DocUtils.getRadomWord());
        map.put("name2", DocUtils.getRadomWord());
        map.put("name3", DocUtils.getRadomWord());
        map.put("name4", DocUtils.getRadomWord());
        map.put("name5", DocUtils.getRadomWord());
        map.put("name6", DocUtils.getRadomWord());


        map.put("key", DocUtils.getRadomWord());
        map.put("key0", DocUtils.getRadomWord());
        map.put("key1", DocUtils.getRadomWord());
        map.put("key2", DocUtils.getRadomWord());
        map.put("key3", DocUtils.getRadomWord());
        map.put("key4", DocUtils.getRadomWord());
        map.put("key5", DocUtils.getRadomWord());
        map.put("key6", DocUtils.getRadomWord());


        map.put("show", DocUtils.getBool());
        map.put("show0", DocUtils.getBool());
        map.put("show1", DocUtils.getBool());
        map.put("show2", DocUtils.getBool());
        map.put("show3", DocUtils.getBool());
        map.put("show4", DocUtils.getBool());
        map.put("show5", DocUtils.getBool());
        map.put("show6", DocUtils.getBool());


        map.put("len", DocUtils.getRandomInt(10));
        map.put("len0", DocUtils.getRandomInt(10));
        map.put("len1", DocUtils.getRandomInt(10));
        map.put("len2", DocUtils.getRandomInt(10));
        map.put("len3", DocUtils.getRandomInt(10));
        map.put("len4", DocUtils.getRandomInt(10));
        map.put("len5", DocUtils.getRandomInt(10));
        map.put("len6", DocUtils.getRandomInt(10));


        return map;
    }


    public static void createTemplate(String temp, String pathName) {
        try {

            Template template = getConfiguration().getTemplate("ftl/" + temp);

            Map paramter = getTextParamter();
//            Writer out = new FileWriter(new File("template/TextView.text"));
            Writer out = new FileWriter(new File(pathName));
            //8.生成静态文件
            template.process(paramter, out);
            //9.关闭流
            out.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void createEextView(String pathName) {
        try {

            Template template = getConfiguration().getTemplate("ftl/EditText.ftl");

            Map paramter = getTextParamter();
//            Writer out = new FileWriter(new File("template/TextView.text"));
            Writer out = new FileWriter(new File(pathName));
            //8.生成静态文件
            template.process(paramter, out);
            //9.关闭流
            out.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static Map getTextParamter() {
        Map map = new HashMap();
        map.put("id", DocUtils.getRadomWord() + DocUtils.getRadomWord());
        map.put("id1", DocUtils.getRadomWord() + DocUtils.getRadomWord());
        map.put("id2", DocUtils.getRadomWord() + DocUtils.getRadomWord());
        map.put("id3", DocUtils.getRadomWord() + DocUtils.getRadomWord());
        map.put("id4", DocUtils.getRadomWord() + DocUtils.getRadomWord());
        map.put("id5", DocUtils.getRadomWord() + DocUtils.getRadomWord());
        map.put("id6", DocUtils.getRadomWord() + DocUtils.getRadomWord());
        map.put("id7", DocUtils.getRadomWord() + DocUtils.getRadomWord());
        map.put("width", DocUtils.getRandomString());
        map.put("height", DocUtils.getRandomString());
        map.put("margin", DocUtils.getRandomString());
        map.put("marginLeft", DocUtils.getRandomString());
        map.put("marginTop", DocUtils.getRandomString());
        map.put("marginEnd", DocUtils.getRandomString());
        map.put("marginRight", DocUtils.getRandomString());
        map.put("backgroundColor", DocUtils.getRandColorCode());
        map.put("hint", DocUtils.getRadomWord());
        map.put("lines", DocUtils.getRandomString(10));
        map.put("maxLength", DocUtils.getRandomString(10));
        map.put("padding", DocUtils.getRandomString());
        map.put("paddingStart", DocUtils.getRandomString());
        map.put("paddingTop", DocUtils.getRandomString());
        map.put("paddingEnd", DocUtils.getRandomString());
        map.put("paddingLeft", DocUtils.getRandomString());
        map.put("paddingRight", DocUtils.getRandomString());
        map.put("paddingBottom", DocUtils.getRandomString());


        map.put("color", DocUtils.getRandColorCode());


        map.put("textColor", DocUtils.getRandColorCode());
        map.put("textColor1", DocUtils.getRandColorCode());
        map.put("textColor2", DocUtils.getRandColorCode());
        map.put("textColor3", DocUtils.getRandColorCode());
        map.put("textColor4", DocUtils.getRandColorCode());

        map.put("isMargin", DocUtils.getBool());
        map.put("text", DocUtils.getRadomWord());
        map.put("text1", DocUtils.getRadomWord());
        map.put("text2", DocUtils.getRadomWord());
        map.put("text3", DocUtils.getRadomWord());
        map.put("text4", DocUtils.getRadomWord());


        map.put("isMargin", DocUtils.getBool());
        map.put("isBackground", DocUtils.getBool());
        map.put("isHint", DocUtils.getBool());
        map.put("isLayoutGravity", DocUtils.getBool());
        map.put("isLines", DocUtils.getBool());
        map.put("isPadding", DocUtils.getBool());
        map.put("isTextColor", DocUtils.getBool());
        map.put("isWidth", DocUtils.getBool());

        map.put("isGone1", DocUtils.getBool());
        map.put("isGone2", DocUtils.getBool());
        map.put("isGone3", DocUtils.getBool());
        map.put("isGone4", DocUtils.getBool());


        return map;
    }


    private static Configuration getConfiguration() throws IOException {
        Configuration configuration = new Configuration(Configuration.getVersion());
        configuration.setDirectoryForTemplateLoading(new File("src/main/resources"));
        configuration.setDefaultEncoding("utf-8");
        return configuration;
    }


    public static void demo2() {
        try {

            Configuration configuration = new Configuration(Configuration.getVersion());
            //3.设置模版文件的保存目录
            configuration.setDirectoryForTemplateLoading(new File("src/main/resources"));
            //4.模版文件的编码方式，一般就是utf-8
            configuration.setDefaultEncoding("utf-8");
            //5.加载一个模版文件，创建一个模版对象。
            Template template = configuration.getTemplate("ftl/hello.ftl");
            //6.创建一个数据集，可以是pojo可以是map，推荐使用map
            Map map = new HashMap();
            map.put("hello", "hello shiye ,my first freeMarker");
            //7.创建一个writer对象，指定输出文件的路径及文件名
            Writer out = new FileWriter(new File("template/hello.text"));
            //8.生成静态文件
            template.process(map, out);
            //9.关闭流
            out.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }


    public static void demo1() {
        try {

            try {
                Map map = new HashMap();
                map.put("name", "张三");
                map.put("money", 10.155);
                map.put("point", 10);
                Template template = new Template("strTpl", "您好${name}，晚上好！您目前余额：${money?string(\"#.##\")}元，积分：${point}", new Configuration(new Version("2.3.23")));
                StringWriter result = new StringWriter();
                template.process(map, result);
                System.out.println(result.toString());
                //您好张三，晚上好！您目前余额：10.16元，积分：10
            } catch (Exception e) {
                e.printStackTrace();
            }
            //您好张三，晚上好！您目前余额：10.16元，积分：10
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
