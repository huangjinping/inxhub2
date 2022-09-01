package com.inx.hub.utils;


import java.nio.Buffer;

public class Converter {

    public static String toMap(String source) {
        StringBuffer buffer = new StringBuffer(source);
        return buffer.reverse().toString();
    }


}
