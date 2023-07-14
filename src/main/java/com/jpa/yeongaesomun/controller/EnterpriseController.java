package com.jpa.yeongaesomun.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/enterprise/*")
public class EnterpriseController {

    @GetMapping("list")
    public void goToIntro() {

    }
}
