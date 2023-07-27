package com.jpa.yeongaesomun.controller.enterprise;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/enterprises/*")
public class EnterpriseRestController {

    @GetMapping("list")
    public void goToIntro() {

    }

    @GetMapping("enterpriseDeTail")
    public void goToEnterpriseDeTail() {

    }
}
