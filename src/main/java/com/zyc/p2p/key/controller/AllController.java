package com.zyc.p2p.key.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AllController {

    @RequestMapping(value = "/login")
    public String toLogin(){
        return "login";
    }

    @RequestMapping(value = "/register")
    public String toRegister(){
        return "register";
    }

    @RequestMapping(value = "/article")
    public String toArticle(){
        return "article";
    }

    @RequestMapping(value = "/borrow")
    public String toBorrow(){
        return "borrow";
    }

    @RequestMapping(value = "/index")
    public String toIndex(){
        return "index";
    }

    @RequestMapping(value = "/invest")
    public String toInvest(){
        return "invest";
    }

    @RequestMapping(value = "/noticelist")
    public String toNoticelist(){
        return "noticelist";
    }

    @RequestMapping(value = "/problem")
    public String toProblem(){
        return "problem";
    }

}
