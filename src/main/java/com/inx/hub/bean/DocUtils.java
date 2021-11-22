package com.inx.hub.bean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.inx.hub.FileUtils;
import com.inx.hub.MD5Utils;

import java.math.BigInteger;
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

//        for (int i = 0; i < 100; i++) {
//            System.out.println(getRadomWord());
//        }

//        System.out.println(getMd5Key("source1"));
//        String source = getMd5Key("source1");
//        String[] array = getArray();
//        int hexToInt = getHexToInt(source.substring(0, 8), array.length);
//        System.out.println(hexToInt);
//        System.out.println(array[hexToInt]);

//        System.out.println(getRadomWord());

//        36cd38f49b9afa08222c0dc9ebfe35eb

//        int var = 19111124;
//        String hex = Integer.toHexString(var);
//
//        System.out.println(hex);
//        BigInteger bi = new BigInteger(hex, 16);
//        System.out.println(bi);
//
//        for (int i = 0; i < 10000; i++) {
//            System.out.println(getName("" + i));
//
//        }


//        int pagesize = 11;
//        int his = pagesize / 3;
//        if (pagesize % 3 > 0) {
//            his = his + 1;
//        }
//
//        System.out.println("=======" + his);

        onStrins("inma1.image");

    }


    private static void onStrins(String oldName) {
        String suffix = oldName.substring(oldName.lastIndexOf(".") + 1);
        System.out.println(suffix);

        if (oldName.contains(".")) {
            oldName = oldName.substring(0, oldName.lastIndexOf("."));
        }
        System.out.println(oldName);

        if (!oldName.equals(suffix)) {
            System.out.println(oldName + "." + suffix);
            return;
        }
        System.out.println(oldName);

    }


    private static String getName(String source) {
        source = getMd5Key(source);
        if (source.length() != 32) {
            return source;
        }
        String[] array = getArray();
        StringBuffer buffer = new StringBuffer();
        int hexToInt = getHexToInt(source.substring(0, 8), array.length);
        buffer.append(array[hexToInt]);
        hexToInt = getHexToInt(source.substring(8, 16), array.length);
        buffer.append(array[hexToInt]);
        hexToInt = getHexToInt(source.substring(16, 24), array.length);
        buffer.append(array[hexToInt]);
        hexToInt = getHexToInt(source.substring(24, 32), array.length);
        buffer.append(array[hexToInt]);
        return buffer.toString();
    }

//    shelteredcounselelusivetraction
//            backlighttillreputediversity
//    naplesminiskirtparachuterheumy
//            rectificationdispleasepearlpeninsular
//    alphanumericprocessingmanagementoutcry

    private static int getHexToInt(String md5, int max) {
        BigInteger bi = new BigInteger(md5, 16);
//        int i = Integer.parseInt(md5.toUpperCase(), 16);
        int result = bi.intValue() % max;
        return Math.abs(result);
    }


    public static String getMd5Key(String source) {
        return MD5Utils.getMD5String(source);
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

        StringBuilder builder = new StringBuilder();
        builder.append(getRadomChild());
        builder.append(getRadomChild());
        if (getBool() == 1) {
            builder.append(getRadomChild());
        }
        String s = builder.toString();
        if (s.length() > 22) {
            s = s.substring(0, 20);
        }

        return s;
    }


    public static String getRadomChild() {
        String[] array = getArray();
        System.out.println("===========1=============");
        System.out.println(array.toString());
        System.out.println("============2============");

        Random random = new Random();
        int nextInt = random.nextInt(array.length - 1);

        try {
            return array[nextInt];
        } catch (Exception e) {
            e.printStackTrace();
        }

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

    static char[] abc = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    /**
     * 生成名称
     *
     * @param index
     * @return
     */
    static String generateName(int index) {
        StringBuffer sb = new StringBuffer();
        int temp = index;
        while (temp >= 0) {
            sb.append(abc[temp % abc.length]);
            temp = temp / abc.length;
            if (temp == 0) {
                temp = -1;
            }
        }
//        sb.append(index);
        return sb.toString();
    }
}
