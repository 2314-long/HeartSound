package com.heartsound.common.user.param;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 修改密码
 *
 * @author sl
 */
@Data
public class UserUpdatePwdReq{

    /**
     * 非必填, 自动填充
     */
    private Long userId;

    /**
     * 旧密码
     */
    @NotBlank(message = "旧密码为必填项")
    private String password;

    /**
     * 新密码
     */
    @NotBlank(message = "新密码为必填项")
    private String newPassword;

    /**
     * 确认密码
     */
    @NotBlank(message = "确认密码为必填项")
    private String confirmPassword;
}
