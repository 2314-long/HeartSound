package com.heartsound.common.user.param;

import lombok.Data;


import javax.validation.constraints.NotBlank;

/**
 * 用户请求
 *
 * @author sl
 */
@Data
public class UserUpdateReq{

    /**
     * 用户名
     */
    @NotBlank(message = "用户名为必填项")
    private String username;
    /**
     * 昵称
     */
    @NotBlank(message = "昵称为必填项")
    private String nickName;
    /**
     * 说明
     */
    @NotBlank(message = "说明为必填项")
    private String remark;
    /**
     * 和风天气的位置
     */
    private String location;
    /**
     * 用户头像
     */
    private String avatar;
}
