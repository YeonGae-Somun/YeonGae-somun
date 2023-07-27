package com.jpa.yeongaesomun.controller.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/users/*")
public class UserRestController {
    @GetMapping("login")
    public void login(){

    }

    @GetMapping("register")
    public void register(){

    }

    @GetMapping("find-password")
    public void goToFindPassword(){

    }

    @GetMapping("new-password")
    public void goToNewPassword(){

    }
}
