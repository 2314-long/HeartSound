package com.heartsound.common.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.SignatureException;

import java.util.Date;

public class JwtUtil {

    // 定义签名密钥
    private static final String SECRET_KEY = "mySecretKey12345songlong090423141056160782heartsound";

    // 生成 Token
    public static String generateToken(Long userId,String username, long expirationTime) {
//        long expirationTime = 1000 * 60 * 60; // 1 小时有效期
        return Jwts.builder()
                .setSubject(username) // 设置主题（用户名）
                .setIssuedAt(new Date()) // 签发时间
                .claim("userId", userId)
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime)) // 设置过期时间
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY) // 设置签名算法和密钥
                .compact(); // 生成 Token
    }

    // 解析 Token
    public static String parseToken(String token) {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(SECRET_KEY) // 设置签名密钥
                    .parseClaimsJws(token) // 解析 Token
                    .getBody();

            return claims.getSubject(); // 获取 Token 中的主题（用户名）
        } catch (SignatureException e) {
            throw new RuntimeException("Invalid Token");
        }
    }

    // 验证 Token
    public static boolean validateToken(String token) {
        try {
            parseToken(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // 解析 Token 获取用户 ID
    public static Long getUserIdFromToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(SECRET_KEY)  // 使用密钥解析
                .parseClaimsJws(token)
                .getBody();
        return claims.get("userId", Long.class);  // 获取存储在 claim 中的 userId
    }
}

