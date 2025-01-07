package com.heartsound.common.user.controller;

import com.heartsound.common.user.pojo.UserEntity;
import com.heartsound.common.user.pojo.UserRes;
import com.heartsound.common.user.service.UserService;
import com.heartsound.common.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/info")
    public R<UserRes> info(){
        return userService.info();
    }
}
