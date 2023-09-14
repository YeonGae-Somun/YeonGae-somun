package com.jpa.yeongaesomun.repository.admin.adminStartupRepository;

import com.jpa.yeongaesomun.domain.entity.member.StartUp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminStartupRepository extends JpaRepository<StartUp, Long>, AdminStartupQueryDSL {
}
