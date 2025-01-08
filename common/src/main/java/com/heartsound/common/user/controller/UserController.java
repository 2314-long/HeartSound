package com.heartsound.common.user.controller;

import com.heartsound.common.user.param.UserUpdatePwdReq;
import com.heartsound.common.user.param.UserUpdateReq;
import com.heartsound.common.user.pojo.UserEntity;
import com.heartsound.common.user.pojo.UserRes;
import com.heartsound.common.user.service.UserService;
import com.heartsound.common.utils.R;
import com.heartsound.common.utils.UserContext;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/info")
    public R<UserRes> info(){
        return userService.info();
    }

    @PostMapping("/upd")
    public R<?> update(@RequestBody UserUpdateReq req){
        return userService.update(req);
    }

    @PostMapping("/upd/pwd")
    public R<?> updatePassword(@RequestBody UserUpdatePwdReq req){
        return userService.updatePassword(req);
    }


}
