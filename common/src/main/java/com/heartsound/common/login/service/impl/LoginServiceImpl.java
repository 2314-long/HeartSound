package com.heartsound.common.login.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.heartsound.common.enums.AuthRCode;
import com.heartsound.common.exception.AuthException;
import com.heartsound.common.login.param.LoginReq;
import com.heartsound.common.login.pojo.AccessToken;
import com.heartsound.common.login.service.LoginService;
import com.heartsound.common.user.mapper.UserMapper;
import com.heartsound.common.user.pojo.UserEntity;
import com.heartsound.common.utils.JwtUtil;
import com.heartsound.common.utils.PasswordManager;
import com.heartsound.common.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public R<AccessToken> login(LoginReq loginReq) {
        AccessToken accessToken = new AccessToken();
        QueryWrapper<UserEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", loginReq.getUsername());
        UserEntity userEntity = userMapper.selectOne(queryWrapper);
        // 验证
        AuthException.throwBy(userEntity==null, AuthRCode.USERNAME_OR_PWD_FAULT);
        AuthException.throwBy(userEntity.getDelTime() == null || !userEntity.getDelTime().equals(0L), AuthRCode.USER_NOT_ENABLED);
        AuthException.throwBy(PasswordManager.hashPassword(loginReq.getPassword()).equals(userEntity.getPassword()), AuthRCode.USERNAME_OR_PWD_FAULT);
        // 获取token
        String token = JwtUtil.generateToken(loginReq.getUsername());
        accessToken.setToken(token);
        accessToken.setUserId(userEntity.getId());
        accessToken.setMultiPlaceLogin(true);
        accessToken.setRequestRefresh(true);
        return R.ok(accessToken);
    }
}
