package com.jpa.yeongaesomun.repository.admin.adminEnterpriseRepository;

import com.jpa.yeongaesomun.domain.entity.member.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminEnterpriseRepository extends JpaRepository<Enterprise, Long>, AdminEnterpriseQueryDSL {
}
