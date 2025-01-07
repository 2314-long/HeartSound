package com.heartsound.common.user.service;

import com.heartsound.common.user.pojo.UserRes;
import com.heartsound.common.utils.R;

public interface UserService {
    R<UserRes> info();
}
