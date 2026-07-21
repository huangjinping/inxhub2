package com.inx.hub;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class packageTest {

    public static void main(String[] args) {

        String json = FileUtils.getTextByPath("/Users/huhuijie/Documents/GitHub/inxhub2/json/packagelist");
//        System.out.println(json);

        start();

    }


    public static void start() {
        String fileName = "/Users/huhuijie/Documents/GitHub/inxhub2/json/packagelist";
        List<String> words = new ArrayList<>();
        // 读取文件
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    words.add("'" + line.trim() + "'");
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return;
        }
        // 输出结果，用逗号分割
        System.out.println(String.join(",", words));
    }
}
