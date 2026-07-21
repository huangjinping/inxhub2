package com.inx.hub;


import com.google.gson.Gson;
import com.inx.hub.bean.User;

public class Test115 {
    public static void main(String[] args) {
        Gson gson = new Gson();
        String app = "{\n" +
                "  \"testFlag\": 1,\n" +
                "  \"name\": \"中国人\"\n" +
                "}";
        User user = gson.fromJson(app, User.class);
        System.out.println(""+user.toString());
    }
}
