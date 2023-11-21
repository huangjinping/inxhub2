package com.inx.hub;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;


public class AESUtil1 {
    private static final String KEY_ALGORITHM = "AES";
    private static final String UNICODE_FORMAT = "UTF-8";
    private static final String CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";


    private static Key toKey(byte[] key) throws Exception {
        SecretKey secretKey = new SecretKeySpec(key, KEY_ALGORITHM);
        return secretKey;
    }

    public static String encrypt(String data, String key) {
        try {
            // 还原密钥
            Key k = toKey(key.getBytes(UNICODE_FORMAT));

            // Security.addProvider(new BouncyCastleProvider());
            Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
            // 初始化，设置为加密模式
            cipher.init(Cipher.ENCRYPT_MODE, k);
            // 执行操作
            return bytes2String(cipher.doFinal(data.getBytes(UNICODE_FORMAT)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String bytes2String(byte buf[]) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex);
        }
        return sb.toString();
    }


}