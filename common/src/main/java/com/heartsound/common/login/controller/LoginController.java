package com.heartsound.common.login.controller;

import com.heartsound.common.login.param.LoginReq;
import com.heartsound.common.login.pojo.AccessToken;
import com.heartsound.common.utils.R;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @RequestMapping("/hello")
    public String test(){
        return "hello";
    }

    @PostMapping("/login")
    public R<AccessToken> login(@RequestBody LoginReq loginReq){
        return null;
    }

}
