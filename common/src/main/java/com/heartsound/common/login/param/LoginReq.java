package com.heartsound.common.login.param;


import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * 登录请求
 *
 * @author sl
 */
@Data
public class LoginReq {

    /**
     * 登录方式，可见数据字典中[GrantType]部分, 必须为小写
     *
     * @see com.heartsound.common.enums.GrantTypeEnum
     */
    @NotEmpty(message = "授权方式[GrantType]为必填项")
    private String grantType;
    /**
     * 客户端ID
     */
    @NotEmpty(message = "客户端ID[ClientId]为必填项")
    private String clientId;

    /**
     * 用户名, grantType = password 时必填
     */
    private String username;
    /**
     * 密码, grantType = password 时必填
     */
    private String password;
}
