package com.heartsound.common.login.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.heartsound.common.enums.AuthRCode;
import com.heartsound.common.exception.AuthException;
import com.heartsound.common.login.param.LoginReq;
import com.heartsound.common.login.pojo.AccessToken;
import com.heartsound.common.login.service.LoginService;
import com.heartsound.common.user.mapper.UserMapper;
import com.heartsound.common.user.pojo.UserEntity;
import com.heartsound.common.utils.*;
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
        AuthException.throwBy(!PasswordManager.verifyPassword(loginReq.getPassword(), userEntity.getPassword()), AuthRCode.USERNAME_OR_PWD_FAULT);

        // 获取token
        long expirationTime = 1000 * 60 * 60; // 1 小时有效期
        String token = JwtUtil.generateToken(userEntity.getId(),loginReq.getUsername(),expirationTime);
        accessToken.setDuration((int)expirationTime/1000);
        accessToken.setToken(token);
        accessToken.setUserId(userEntity.getId());
        accessToken.setMultiPlaceLogin(true);
        accessToken.setRequestRefresh(true);
        accessToken.setExpire(System.currentTimeMillis()+expirationTime);
        accessToken.setLoginTime(TimeUtil.getCurrentTimeString());
        return R.ok(accessToken);
    }
}
