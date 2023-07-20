package com.jpa.yeongaesomun.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/mypage/*")
public class MypageController {
    @GetMapping("supporter")
    public void goToMypageSupporter(){

    }

    @GetMapping("maker")
    public void goToMypageMaker(){

    }

    @GetMapping("enterprise-register")
    public void goToEnterpriseRegister(){

    }


    @GetMapping("setting")
    public void goToSetting(){

    }

    @GetMapping("profile-setting")
    public void goToProfileSetting(){

    }

    @PostMapping("info-setting")
    public void goToInfoSetting(){

    }

    @GetMapping("check-password")
    public void goToCheckPassWord(){

    }

    @GetMapping("setting-password")
    public void goToSettingPassWord(){

    }

    @GetMapping("setting-alarm")
    public void goToSettingAlarm(){

    }

    @GetMapping("wish-list")
    public void goToWishList(){

    }

    @GetMapping("event")
    public void goToEvent(){

    }

    @GetMapping("delete-account")
    public void goToDeleteAccount(){

    }

    @GetMapping("write")
    public void goToWrite(){
        
    }

    @GetMapping("post-write")
    public void goToPostWrite(){

    }
}
