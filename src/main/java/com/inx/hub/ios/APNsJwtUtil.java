package com.inx.hub.ios;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.time.Instant;
import java.util.Date;

public class APNsJwtUtil {
    // 从 .p8 文件加载密钥
    public static Key loadPrivateKey(String p8FilePath) throws Exception {
        try (InputStream is = new FileInputStream(p8FilePath)) {
            byte[] keyBytes = new byte[is.available()];
            is.read(keyBytes);
            String keyString = new String(keyBytes, StandardCharsets.UTF_8)
                    .replace("-----BEGIN PRIVATE KEY-----", "")
                    .replace("-----END PRIVATE KEY-----", "")
                    .replaceAll("\\s+", ""); // 去除换行和空格
            return Keys.hmacShaKeyFor(java.util.Base64.getDecoder().decode(keyString));
        }
    }

    // 生成 JWT 令牌
    public static String generateJwtToken(Key privateKey, String teamId, String keyId) {
        // 令牌有效期：当前时间 + 3600 秒（1 小时）
        Instant now = Instant.now();
        return Jwts.builder()
                .setIssuer(teamId) // 开发者 Team ID
                .setIssuedAt(Date.from(now)) // 生成时间
                .setExpiration(Date.from(now.plusSeconds(3600))) // 过期时间
                .signWith(privateKey, SignatureAlgorithm.ES256) // 签名算法必须为 ES256
                .setHeaderParam("kid", keyId) // Key ID
                .compact();
    }
}