package com.jpa.yeongaesomun.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/start-up/*")
public class StartUpController {

    @GetMapping("list")
    public void goToStartUpIntro(){

    }





}