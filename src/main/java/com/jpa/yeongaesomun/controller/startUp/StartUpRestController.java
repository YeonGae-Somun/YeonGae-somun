package com.jpa.yeongaesomun.controller.startUp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/start-ups/*")
public class StartUpRestController {

    @GetMapping("list")
    public void goToStartUpIntro(){

    }

    @GetMapping("startUpDetail")
    public void goToStartUpDetail(){

    }
}
