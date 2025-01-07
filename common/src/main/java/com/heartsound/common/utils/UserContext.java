package com.heartsound.common.utils;

public class UserContext {
    private static final ThreadLocal<String> currentToken = new ThreadLocal<>();

    private static final ThreadLocal<Long> currentUserId = new ThreadLocal<>();

    public static void setToken(String token) {
        currentToken.set(token);
    }

    public static String getToken() {
        return currentToken.get();
    }

    public static void setUserId(Long userId) {
        currentUserId.set(userId);
    }

    public static Long getUserId() {
        return currentUserId.get();
    }

    public static void clear() {
        currentToken.remove();
        currentUserId.remove();
    }
}

