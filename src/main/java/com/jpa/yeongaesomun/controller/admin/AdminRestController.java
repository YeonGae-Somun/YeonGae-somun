package com.jpa.yeongaesomun.controller.admin;

import com.jpa.yeongaesomun.domain.entity.member.Enterprise;
import com.jpa.yeongaesomun.domain.entity.member.Search;
import com.jpa.yeongaesomun.domain.entity.member.User;
import com.jpa.yeongaesomun.domain.entity.notice.Notice;
import com.jpa.yeongaesomun.domain.entity.notice.NoticeDTO;
import com.jpa.yeongaesomun.service.admin.adminEnterprise.AdminEnterpriseService;
import com.jpa.yeongaesomun.service.admin.adminNotice.AdminNoticeService;
import com.jpa.yeongaesomun.service.admin.adminUser.AdminUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/admins/*")
public class AdminRestController {
    private final AdminUserService adminUserService;
    private final AdminEnterpriseService adminEnterpriseService;
    private final AdminNoticeService adminNoticeService;


    @GetMapping("admin")
    public void goToAdmin(){

    }

    @GetMapping("main")
    public void goToMain(){

    }

    @GetMapping("member")
    public void goToMember(){

    }

    @PostMapping("member/delete")
    public void deleteAll(@RequestBody List<Long> ids){
        adminUserService.deleteAllById(ids);
        log.info(ids.toString());
    }

    @GetMapping("enterprise")
    public void goToEnterprise(){

    }

    @PostMapping("enterprise/delete")
    public void deleteEnterpriseAll(@RequestBody List<Long> ids){
        adminEnterpriseService.deleteAllById(ids);
        log.info(ids.toString());
    }

    @PostMapping("enterprise-estimate")
    public Page<Enterprise> goToEnterpriseEstimate(Pageable pageable, Model model, Search search){
        final Page<Enterprise> pagination = adminEnterpriseService.getList(pageable, search);
        model.addAttribute("pagination", pagination);
        log.info(pagination.toString());
        return adminEnterpriseService.getList(pageable, search);
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
    public Page<Notice> goToNoticeUpdateForm(Pageable pageable, Model model, Search search){
        final Page<Notice> pagination = adminNoticeService.getList(pageable, search);
        model.addAttribute("pagination", pagination);
        log.info(pagination.toString());
        return adminNoticeService.getList(pageable, search);
    }

    @PostMapping("notice-update-form")
    public RedirectView goToUpdate(NoticeDTO notice){
        adminNoticeService.update(notice);
        return new RedirectView("/notice/" + notice.getId());
    }

    @GetMapping("one-day-experience")
    public void goToOneDayExperience(){

    }

    @GetMapping("start-up-product-experience")
    public void goToStartUpProductExperience(){

    }
}
