package com.longgroup.managesystem.controller;

import com.longgroup.managesystem.annotation.PassToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@PassToken
public class redirectController {
    @RequestMapping("/")
    @PassToken
    public String login(){
        return "redirect:index.html";
    }
}
