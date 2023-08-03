package com.jpa.yeongaesomun.repository.memberRepository;

import com.jpa.yeongaesomun.domain.entity.member.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<User,Long>,MemberQueryDSL{
}
