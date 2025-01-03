package com.heartsound.common.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordManager {

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    // 加密密码
    public static String hashPassword(String plainPassword) {
        return encoder.encode(plainPassword);
    }

    // 验证密码
    public static boolean verifyPassword(String plainPassword, String hashedPassword) {
        return encoder.matches(plainPassword, hashedPassword);
    }

//    public static void main(String[] args) {
//        String password = "blos";
//
//        // 生成哈希密码
//        String hashedPassword = hashPassword(password);
//        System.out.println("Hashed Password: " + hashedPassword);
//
//        // 验证密码
//        boolean isValid = verifyPassword(password, hashedPassword);
//        System.out.println("Password valid: " + isValid);
//    }
}
