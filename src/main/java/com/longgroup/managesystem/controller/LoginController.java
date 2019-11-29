package com.longgroup.managesystem.controller;

import com.alibaba.fastjson.JSONObject;
import com.longgroup.managesystem.service.LoginService;
import com.longgroup.managesystem.service.TokenService;
import com.longgroup.managesystem.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("login")
public class LoginController {
    @Autowired
    private LoginService loginService;
    @Autowired
    TokenService tokenService;

    @RequestMapping("/login/{id}")
    public Result login(@PathVariable(value="id") String id, @RequestBody Map map){
        String username = map.get("username").toString();
        String password = map.get("password").toString();
        Result result;
        try {
            List login = loginService.login(username, password);
            if (login.size() == 0) {
                result = new Result(false, "账号或密码错误");
            }else {
                result = new Result(true, login);
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = new Result(false, "登陆失败，失败原因:" + e.getMessage());
        }
        return result;
    }


  /*  //登录
    @PostMapping("/login")
    public Object login(@RequestBody Model model){
        JSONObject jsonObject=new JSONObject();
//        User userForBase = loginService.findByUsername(user);
        List login = loginService.login(username, password);
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
    }*/

}
