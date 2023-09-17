package com.jpa.yeongaesomun.repository.memberRepository;

import com.jpa.yeongaesomun.domain.entity.member.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<User,Long>,MemberQueryDSL{
    //    아이디로 전체 정보 조회
    public Optional<User> findByUserEmail(String userEmail);

    //    이메일로 전체 정보 조회
//    public Optional<User> findByMemberEmail(String memberEmail);
}
