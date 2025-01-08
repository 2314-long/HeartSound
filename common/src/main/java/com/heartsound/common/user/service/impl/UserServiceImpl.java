package com.heartsound.common.user.service.impl;

import com.heartsound.common.exception.AuthException;
import com.heartsound.common.user.mapper.UserMapper;
import com.heartsound.common.user.param.UserUpdatePwdReq;
import com.heartsound.common.user.param.UserUpdateReq;
import com.heartsound.common.user.pojo.UserEntity;
import com.heartsound.common.user.pojo.UserRes;
import com.heartsound.common.user.service.UserService;
import com.heartsound.common.utils.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    public R<UserRes> info(){
        Long userId = UserContext.getUserId();
        UserEntity userEntity = userMapper.selectById(userId);
        AuthException.throwBy(userEntity==null,"404000","用户查询不到！");
        UserRes userRes = new UserRes();
        BeanUtils.copyProperties(userEntity,userRes);
        return R.ok(userRes);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public R<?> update(UserUpdateReq req) {
        UserEntity user = new UserEntity();
        BeanUtils.copyProperties(req,user);
        Long userId = UserContext.getUserId();
        user.setId(userId);
        userMapper.updateById(user);
        return R.ok();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public R<?> updatePassword(UserUpdatePwdReq req) {
        req.setUserId(UserContext.getUserId());
        AuthException.throwBy(!req.getNewPassword().equals(req.getConfirmPassword()), RCode.INCONSISTENT_PASSWORD);
        UserEntity user = userMapper.selectById(req.getUserId());
        AuthException.throwBy(!PasswordManager.verifyPassword(req.getPassword(),user.getPassword()),RCode.INCORRECT_PASSWORD);
        user.setPassword(PasswordManager.hashPassword(req.getConfirmPassword()));
        userMapper.updateById(user);
        return R.ok();
    }


}
