package com.jpa.yeongaesomun.admin;

import com.jpa.yeongaesomun.domain.entity.member.Enterprise;
import com.jpa.yeongaesomun.domain.entity.notice.Notice;
import com.jpa.yeongaesomun.repository.admin.adminEnterpriseRepository.AdminEnterpriseRepository;
import com.jpa.yeongaesomun.repository.admin.adminNoticeRepository.AdminNoticeRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
@Transactional
@Rollback(false)
@Slf4j
public class AdminNoticeTests {
    @Autowired
    private AdminNoticeRepository adminNoticeRepository;

    @Test
    public void saveTest(){
        for(int i=0; i<20; i++) {
            Notice notice = new Notice();
            notice.setNoticeTitle("타이틀1" + i);
            notice.setNoticeContent("내용입니당12312");
            notice.setNoticeWriter("한동석");
            notice.setNoticeReleaseDate(LocalDateTime.now());
            notice.setNoticeUpdateDate(LocalDate.of(2002, 10, 28));


            adminNoticeRepository.save(notice);
        }
    }
}
