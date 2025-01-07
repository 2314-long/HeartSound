package com.heartsound.common.utils;

public class UserContext {
    private static final ThreadLocal<String> currentToken = new ThreadLocal<>();

    public static void setToken(String token) {
        currentToken.set(token);
    }

    public static String getToken() {
        return currentToken.get();
    }

    public static void clear() {
        currentToken.remove();
    }
}

