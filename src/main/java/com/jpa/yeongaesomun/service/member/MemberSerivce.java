package com.jpa.yeongaesomun.service.member;

import com.jpa.yeongaesomun.domain.domain.MemberDTO;
import com.jpa.yeongaesomun.domain.entity.member.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

public interface MemberSerivce extends UserDetailsService{


    //    회원가입
    public void join(MemberDTO memberDTO, PasswordEncoder passwordEncoder);

    //    회원가입(OAuth)
    public void join(MemberDTO memberDTO);

    public default User toEntity(MemberDTO memberDTO){
        return User.builder()
                .userEmail(memberDTO.getUserEmail())
                .userNickname(memberDTO.getUserNickname())
                .build();
    }
}
