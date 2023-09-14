package com.jpa.yeongaesomun.admin;

import com.jpa.yeongaesomun.domain.entity.member.User;
import com.jpa.yeongaesomun.domain.enumType.MemberGender;
import com.jpa.yeongaesomun.domain.enumType.MemberRole;
import com.jpa.yeongaesomun.domain.enumType.MemberStatus;
import com.jpa.yeongaesomun.domain.enumType.MemberType;
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
public class AdminUserTests {


    @Autowired
    private AdminUserRepository adminUserRepository;

    @Test
    public void saveTest(){
        for(int i=0; i<50; i++) {
            User user = new User();
            user.setUserEmail("final@google.com" + i);
            user.setUserPassword("8555");
            user.setUserNickname("이제끝남" + i);
            user.setUserName("문우람" + i);
            user.setUserCellPhone("010-7777-8668");
            user.setUserBirthDate(LocalDate.of(2002, 11, 22));
            user.setUserGender(MemberGender.FEMALE);
            user.setUserRole(MemberRole.USER);
            user.setUserStatus(MemberStatus.DELETED);
            user.setUserType(MemberType.USER);
            user.setUserReleaseDate(LocalDateTime.now());

            adminUserRepository.save(user);
        }
    }
}
