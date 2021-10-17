package com.inx.hub.bean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.inx.hub.FileUtils;

import java.util.List;
import java.util.Random;

public class DocUtils {

    static String[] docArray;


    public static void main(String[] args) {
//        String json = FileUtils.readFile("json/result.json");
//        Gson gson = new Gson();
//        System.out.println(json);
//        List<Doc> ps = gson.fromJson(json, new TypeToken<List<Doc>>() {
//        }.getType());
//        System.out.println(json.toString());
//
//        StringBuffer buffer = new StringBuffer();
//        for (Doc doc : ps
//        ) {
//
//            buffer.append("\"");
//            buffer.append(doc.getWord());
//            buffer.append("\"");
//            buffer.append(",");
//
//        }
//        System.out.println(buffer.toString());
//        System.out.println(docArray.length);

        for (int i = 0; i < 100000; i++) {
            System.out.println(getBool());
        }


    }


    public static String getRandColorCode() {
        String r, g, b;
        Random random = new Random();
        r = Integer.toHexString(random.nextInt(256)).toUpperCase();
        g = Integer.toHexString(random.nextInt(256)).toUpperCase();
        b = Integer.toHexString(random.nextInt(256)).toUpperCase();

        r = r.length() == 1 ? "0" + r : r;
        g = g.length() == 1 ? "0" + g : g;
        b = b.length() == 1 ? "0" + b : b;

        return r + g + b;
    }

    static Random random = new Random();

    public static int getRandomInt(int length) {
        return random.nextInt(length);
    }

    public static String getRandomString(int length) {
        return random.nextInt(length) + "";
    }

    public static String getRandomString() {
        Random random = new Random();
        return random.nextInt(200) + "";
    }


    public static int getBool() {
        return random.nextInt(2);
    }


    public static String getRadomWord() {
        String[] array = getArray();
        Random random = new Random();
        int nextInt = random.nextInt(array.length - 1);
        return array[nextInt];
    }


    public static String[] getArray() {
        if (docArray == null) {
            String json = FileUtils.readFile("json/result.json");
            Gson gson = new Gson();
            List<Doc> ps = gson.fromJson(json, new TypeToken<List<Doc>>() {
            }.getType());
            docArray = new String[ps.size()];
            for (int i = 0; i < ps.size(); i++) {
                docArray[i] = ps.get(i).getWord();
            }
        }
        return docArray;

    }
}
