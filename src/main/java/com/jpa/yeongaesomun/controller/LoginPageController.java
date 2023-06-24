package com.jpa.yeongaesomun.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/login/*")
public class LoginPageController {
    @GetMapping("login")
    public void login(){

    }

    @GetMapping("register")
    public void register(){

    }

    @GetMapping("find-password")
    public void goToFindPassword(){

    }
}
