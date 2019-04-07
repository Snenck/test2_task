package com.qf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
    @RequestMapping("home")
    public String home(){
        return "home";
    }
    @RequestMapping("/toTCAndStu")
    public String toTCAndStu(){
        return "selStAndTC";
    }
}
