package com.longgroup.managesystem.controller;

import com.longgroup.managesystem.service.LoginService;
import com.longgroup.managesystem.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("login")
public class LoginController {
    @Autowired
    private LoginService loginService;
    @RequestMapping("/login")
    public Result login(String username,String password){
        Result result;
        try {
            //增加
//            int i = loginService.login(username, password);
            //查询
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

}
