package com.heartsound.common.login.service;

import com.heartsound.common.login.param.LoginReq;
import com.heartsound.common.login.pojo.AccessToken;
import com.heartsound.common.utils.R;

public interface LoginService {
    R<AccessToken> login(LoginReq loginReq);
}
