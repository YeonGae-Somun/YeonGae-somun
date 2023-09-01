package com.jpa.yeongaesomun.admin;

import com.jpa.yeongaesomun.domain.entity.member.Enterprise;
import com.jpa.yeongaesomun.domain.entity.member.User;
import com.jpa.yeongaesomun.domain.enumType.MemberGender;
import com.jpa.yeongaesomun.domain.enumType.MemberRole;
import com.jpa.yeongaesomun.domain.enumType.MemberStatus;
import com.jpa.yeongaesomun.domain.enumType.MemberType;
import com.jpa.yeongaesomun.repository.admin.adminEnterpriseRepository.AdminEnterpriseRepository;
import com.jpa.yeongaesomun.repository.admin.adminUserRepository.AdminUserRepository;
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
public class AdminEnterpriseTests {
    @Autowired
    private AdminEnterpriseRepository adminEnterpriseRepository;

    @Test
    public void saveTest(){
        for(int i=0; i<10; i++) {
            Enterprise enterprise = new Enterprise();
            enterprise.setEBusinessNumber("10" + i);
            enterprise.setEBusineesName("IBM");
            enterprise.setEManager("김민수" + i);
            enterprise.setEHomepage("IBMKorea@naver.com");
            enterprise.setEMajor("개발산업");
            enterprise.setELocation("서울시 관악구");
            enterprise.setEContent("컨텐츠예용1" + i);


            adminEnterpriseRepository.save(enterprise);
        }
    }
}
