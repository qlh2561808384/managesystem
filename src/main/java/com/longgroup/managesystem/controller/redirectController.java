package com.longgroup.managesystem.controller;

import com.longgroup.managesystem.annotation.PassToken;
import com.longgroup.managesystem.annotation.UserLoginToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class redirectController {
    @RequestMapping("/home")
    @PassToken
    public String login(){
        return "redirect:login/login.html";
    }
}
