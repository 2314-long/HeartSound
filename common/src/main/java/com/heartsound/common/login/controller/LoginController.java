package com.heartsound.common.login.controller;

import com.heartsound.common.login.param.LoginReq;
import com.heartsound.common.login.pojo.AccessToken;
import com.heartsound.common.login.service.LoginService;
import com.heartsound.common.utils.R;
import com.heartsound.common.utils.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class LoginController {

    @Autowired
    private LoginService loginService;
    @RequestMapping("/hello")
    public String test(){
        return "hello";
    }

    @PostMapping("/login")
    public R<AccessToken> login(@RequestBody LoginReq loginReq){
        return loginService.login(loginReq);
    }

    @GetMapping("/check")
    public R<AccessToken> check(){
        AccessToken accessToken = new AccessToken();
        String token = UserContext.getToken();
        accessToken.setToken(token);
        return R.ok(accessToken);
    }

}
