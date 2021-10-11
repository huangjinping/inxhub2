package com.inx.hub;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.Version;

import java.io.File;
import java.io.FileWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

public class TemplateLauncer {

    public static void main(String[] args) {

//        demo1();
        demo2();
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
