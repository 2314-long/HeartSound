package com.heartsound.common.user.service.impl;

import com.heartsound.common.exception.AuthException;
import com.heartsound.common.user.mapper.UserMapper;
import com.heartsound.common.user.pojo.UserEntity;
import com.heartsound.common.user.pojo.UserRes;
import com.heartsound.common.user.service.UserService;
import com.heartsound.common.utils.R;
import com.heartsound.common.utils.UserContext;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
