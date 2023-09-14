package com.jpa.yeongaesomun.controller.admin;


import com.jpa.yeongaesomun.domain.entity.member.Enterprise;
import com.jpa.yeongaesomun.domain.entity.member.StartUp;
import com.jpa.yeongaesomun.domain.entity.member.User;
import com.jpa.yeongaesomun.domain.entity.member.Search;
import com.jpa.yeongaesomun.domain.entity.notice.Notice;
import com.jpa.yeongaesomun.domain.entity.notice.NoticeDTO;
import com.jpa.yeongaesomun.service.admin.adminEnterprise.AdminEnterpriseService;
import com.jpa.yeongaesomun.service.admin.adminNotice.AdminNoticeService;
import com.jpa.yeongaesomun.service.admin.adminUser.AdminUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/admin/*")
public class AdminController {
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
    public Page<User> goToMember(@PageableDefault(page = 0, size = 10) Pageable pageable, Search userSearch, Model model){
        final Page<User> pagination = adminUserService.getList(pageable, userSearch);
        model.addAttribute("pagination", pagination);
        model.addAttribute("search", userSearch);
        log.info(pagination.toString());
        log.info(userSearch.toString());
        return adminUserService.getList(pageable, userSearch);
    }


    // 게시글 조회
    @GetMapping("{id}")
    public User getUser(@PathVariable Long id) {
        return adminUserService.getUser(id);
    }

    @GetMapping("enterprise")
    public Page<Enterprise> goToEnterprise(@PageableDefault(page = 0, size = 10) Pageable pageable, Search enterpriseSearch, Model model){
        final Page<Enterprise> pagination = adminEnterpriseService.getList(pageable, enterpriseSearch);
        model.addAttribute("pagination", pagination);
        model.addAttribute("enterpriseSearch", enterpriseSearch);

        return adminEnterpriseService.getList(pageable, enterpriseSearch);
    }

    @GetMapping("enterprise-estimate")
    public void goToEnterpriseEstimate(){

    }

    @GetMapping("enterprise-detail")
    public void goToEnterpriseDetail(Long id, Model model){
        model.addAttribute("enterprise", adminEnterpriseService.getEnterpriseDTO(id));
    }


    @GetMapping("start-up")
    public Page<StartUp> goToStartUp(@PageableDefault(page = 0, size = 10) Pageable pageable, Search enterpriseSearch, Model model){
//        final Page<Enterprise> pagination = adminEnterpriseService.getList(pageable, enterpriseSearch);
//
//        model.addAttribute("pagination", pagination);
//        return adminS.getList(pageable, enterpriseSearch);
        return null;
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
    public Page<Notice> goToNotice(@PageableDefault(page = 0, size = 10) Pageable pageable, Search enterpriseSearch, Model model){
        final Page<Notice> pagination = adminNoticeService.getList(pageable, enterpriseSearch);

        model.addAttribute("pagination", pagination);
        return adminNoticeService.getList(pageable, enterpriseSearch);
    }

    @GetMapping("notice-form")
    public void goToNoticeForm(Long id, Model model){

    }

    @PostMapping("notice-write")
    public RedirectView write(NoticeDTO noticeDTO) {
        adminNoticeService.saveNoticeDTO(noticeDTO);
        return new RedirectView("/admin/notice");
    }


    @GetMapping("notice-update-form")
    public void goToNoticeUpdateForm(Long id, Model model){
        model.addAttribute("notice", adminNoticeService.getNoticeDTO(id));
    }

    @PostMapping("notice-update")
    public RedirectView modify(NoticeDTO noticeDTO){
        log.info(noticeDTO.toString());
        adminNoticeService.update(noticeDTO);
        return new RedirectView("/admin/notice/");
    }

    @PostMapping("notice-update-form")
    public RedirectView goToUpdate(NoticeDTO notice){
        adminNoticeService.saveNoticeDTO(notice);
        return new RedirectView("/notice/" + notice.getId());
    }

    @GetMapping("one-day-experience")
    public void goToOneDayExperience(){

    }
    @GetMapping("start-up-product-experience")
    public void goToStartUpProductExperience(){

    }

}
