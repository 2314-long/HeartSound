package com.heartsound.common.user.pojo;

import lombok.Data;

/**
 * 对象存储配置
 *
 * @author sl
 */
@Data
public class OSRes {

    /**
     * 对象存储类型
     */
    private String osType;
    /**
     * bucket 名称
     */
    private String bucketName;
    /**
     * 请求域名
     */
    private String domain;
    /**
     * 保存路径
     */
    private String defaultPath;
}
