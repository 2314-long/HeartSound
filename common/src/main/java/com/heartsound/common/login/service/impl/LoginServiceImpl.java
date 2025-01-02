package com.heartsound.common.login.service.impl;

import com.heartsound.common.login.param.LoginReq;
import com.heartsound.common.login.pojo.AccessToken;
import com.heartsound.common.login.service.LoginService;
import com.heartsound.common.user.UserMapper;
import com.heartsound.common.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public R<AccessToken> login(LoginReq loginReq) {
        userMapper.selectOne()
        return null;
    }
}
