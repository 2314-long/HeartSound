package com.heartsound.common.user.service;

import com.heartsound.common.user.param.UserUpdatePwdReq;
import com.heartsound.common.user.param.UserUpdateReq;
import com.heartsound.common.user.pojo.UserRes;
import com.heartsound.common.utils.R;

public interface UserService {
    R<UserRes> info();

    R<?> update(UserUpdateReq req);

    R<?> updatePassword(UserUpdatePwdReq req);
}
