package com.example.elasticsearch.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/security")
public class SecurityController {

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @Secured(value = "ROLE_abc")
    @PreAuthorize("hasAuthority('admin')")
    public String login(){

        return "redirect:main.html";
    }

    @RequestMapping(value = "/toError",method = RequestMethod.POST)
    public String toError(){
        return "redirect:error.html";
    }
}
