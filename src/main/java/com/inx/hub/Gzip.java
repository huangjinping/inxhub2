package com.inx.hub;

public class Gzip {

    public static void main(String[] args) {
        try {
            String ddddd = GzipUtil.compress("58Èøò同城");
            System.out.println(ddddd);
            ddddd = AESUtil.encrypt(ddddd, "092d9530a9e8ddf3c66450eb54c8ac79");
            System.out.println(ddddd);
            ddddd = AESUtil.decrypt(ddddd, "092d9530a9e8ddf3c66450eb54c8ac79");
            System.out.println(ddddd);
            String s = GzipUtil.unCompress(ddddd);
            System.out.println(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
