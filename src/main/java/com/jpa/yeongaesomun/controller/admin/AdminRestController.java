package com.jpa.yeongaesomun.controller.admin;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/admins/*")
public class AdminRestController {

    @GetMapping("admin")
    public void goToAdmin(){

    }

    @GetMapping("main")
    public void goToMain(){

    }

    @GetMapping("member")
    public void goToMember(){

    }

    @GetMapping("enterprise")
    public void goToEnterprise(){

    }

    @GetMapping("enterprise-estimate")
    public void goToEnterpriseEstimate(){

    }

    @GetMapping("enterprise-detail")
    public void goToEnterpriseDetail(){

    }

    @GetMapping("start-up")
    public void goToStartUp(){

    }

    @GetMapping("start-up-estimate")
    public void goToStartUpEstimate(){

    }

    @GetMapping("start-up-detail")
    public void goToStartUpDetail(){

    }


    @GetMapping("qna")
    public void goToQna(){

    }

    @GetMapping("qna-form")
    public void goToQnaForm(){

    }

    @GetMapping("qna-update-form")
    public void goToQnaUpdate(){

    }

    @GetMapping("notice")
    public void goToNotice(){

    }

    @GetMapping("notice-form")
    public void goToNoticeForm(){

    }

    @GetMapping("notice-update-form")
    public void goToNoticeUpdateForm(){

    }

    @GetMapping("one-day-experience")
    public void goToOneDayExperience(){

    }

    @GetMapping("start-up-product-experience")
    public void goToStartUpProductExperience(){

    }
}
