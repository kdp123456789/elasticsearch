package com.example.elasticsearch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/security")
public class SecurityController {

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(){
        return "redirect:main.html";
    }

    @RequestMapping(value = "/toError",method = RequestMethod.POST)
    public String toError(){
        return "redirect:error.html";
    }
}
