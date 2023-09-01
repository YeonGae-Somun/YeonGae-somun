package com.jpa.yeongaesomun.repository.admin.adminNoticeRepository;

import com.jpa.yeongaesomun.domain.entity.notice.Notice;
import com.jpa.yeongaesomun.repository.admin.adminNoticeRepository.AdminNoticeQueryDSL;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminNoticeRepository extends JpaRepository<Notice, Long>, AdminNoticeQueryDSL {
}
