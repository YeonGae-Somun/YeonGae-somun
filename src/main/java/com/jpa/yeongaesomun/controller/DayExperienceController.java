package com.jpa.yeongaesomun.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/day-experience/*")
public class DayExperienceController {

    @GetMapping("list")
    public void goToList(){

    }
}
