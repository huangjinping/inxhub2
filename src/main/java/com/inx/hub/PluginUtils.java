package com.inx.hub;

/**
 * author Created by harrishuang on 2021/2/23.
 * email : huangjinping1000@163.com
 */
public class PluginUtils {


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
        sb.append(index);
        return sb.toString();
    }

    public static String randomWord() {
        int length = 12 + (int) (Math.random() * 9);
        String word = "";
        for (int i = 0; i < length; i++) {
            word += (char) randomChar();
        }
        return word;
    }

    public static byte randomChar() {
        int flag = (int) (Math.random() * 2);// 0小写字母1大写字母
        byte resultBt;
        if (flag == 0) {
            byte bt = (byte) (Math.random() * 26);// 0 <= bt < 26
            resultBt = (byte) (65 + bt);
        } else {
            byte bt = (byte) (Math.random() * 26);// 0 <= bt < 26
            resultBt = (byte) (97 + bt);
        }
        return resultBt;
    }

    public static String upperFirstLatter2(String letter) {
        return letter.substring(0, 1).toUpperCase() + letter.substring(1);
    }

}
