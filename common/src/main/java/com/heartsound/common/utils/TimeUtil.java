package com.heartsound.common.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeUtil {
    public static String getCurrentTimeString() {
        // 获取当前时间
        LocalDateTime now = LocalDateTime.now();
        // 定义格式化器
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        // 格式化时间
        return now.format(formatter);
    }

}
