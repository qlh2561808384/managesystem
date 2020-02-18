package com.longgroup.managesystem.controller;

import com.alibaba.fastjson.JSONObject;
import com.longgroup.managesystem.annotation.UserLoginToken;
import com.longgroup.managesystem.domain.Users;
import com.longgroup.managesystem.service.LoginService;
import com.longgroup.managesystem.service.TokenService;
import com.longgroup.managesystem.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("login")
public class LoginController {
    @Autowired
    private LoginService loginService;
    @Autowired
    TokenService tokenService;
/**
 *     @PathVariable：接收url后面的"?"前面的参数
 *     @RequestParam: 接收url"?"后面的参数
 * @return
 * @author qlh
 * @creed: Talk is cheap,show me the code
 * @date
 */
//    @UserLoginToken
    @RequestMapping("/login/{id}")
    public Result login(@PathVariable(value="id") String id, @RequestBody Map map){
        JSONObject jsonObject=new JSONObject();
        Result result = new Result();
        String username = map.get("username").toString();
        String password = map.get("password").toString();
       Users userForBase = loginService.login(username, password);
        if(userForBase==null){
            result.setSuccess(false);
            result.setContent("账号不存在");
            return result;
        }else {
            String token = tokenService.getToken(userForBase);
            jsonObject.put("token", token);
            jsonObject.put("user", userForBase);
            result.setSuccess(true);
            result.setContent(jsonObject);
            return result;
        }
    }

    @RequestMapping("/register")
    public Result register(String name,String password,String time){
        Result result = null;
        try {
            loginService.register(name,password,time);
            result = new Result(true, "");
        } catch (Exception e) {
            result = new Result(false, e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping("/checkUsername")
    public List<Users> checkUsername(String name){
        List<Users> list = new ArrayList<>();
        try {
            Users users = loginService.checkUsername(name);
            list.add(users);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}
