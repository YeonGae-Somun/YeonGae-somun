package com.jpa.yeongaesomun.domain.domain;

import com.jpa.yeongaesomun.domain.entity.member.User;
import com.jpa.yeongaesomun.domain.enumType.MemberRole;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDate;

@Component
@Data
@NoArgsConstructor
public class MemberDTO implements Serializable {

    private String userNickname;
    private String userEmail;
    private MemberRole userRole;

    public MemberDTO(User user){
        this.userNickname = user.getUserNickname();
        this.userEmail = user.getUserEmail();
    }
}


















