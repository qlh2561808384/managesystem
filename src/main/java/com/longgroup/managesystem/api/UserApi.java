/*
package com.longgroup.managesystem.api;

import com.alibaba.fastjson.JSONObject;
import com.longgroup.managesystem.annotation.UserLoginToken;
import com.longgroup.managesystem.domain.Users;
import com.longgroup.managesystem.service.LoginService;
import com.longgroup.managesystem.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

*/
/**
 * @author jinbin
 * @date 2018-07-08 20:45
 *//*

@RestController
@RequestMapping("api")
public class UserApi {
    @Autowired
    LoginService loginService;
    @Autowired
    TokenService tokenService;
    @Autowired
    private Users user;
    //登录
    @PostMapping("/login")
    public Object login(){
        JSONObject jsonObject=new JSONObject();
        User userForBase = loginService.findByUsername(user);
        if(userForBase==null){
            jsonObject.put("message","登录失败,用户不存在");
            return jsonObject;
        }else {
            if (!userForBase.getPassword().equals(user.getPassword())){
                jsonObject.put("message","登录失败,密码错误");
                return jsonObject;
            }else {
                String token = tokenService.getToken(userForBase);
                jsonObject.put("token", token);
                jsonObject.put("user", userForBase);
                return jsonObject;
            }
        }
    }
    @UserLoginToken
    @GetMapping("/getMessage")
    public String getMessage(){
        return "你已通过验证";
    }
}
*/
