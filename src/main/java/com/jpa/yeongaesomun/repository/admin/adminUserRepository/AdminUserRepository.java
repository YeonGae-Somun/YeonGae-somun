package com.jpa.yeongaesomun.repository.admin.adminUserRepository;

import com.jpa.yeongaesomun.domain.entity.member.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminUserRepository extends JpaRepository<User, Long>, AdminUserQueryDSL {
}
