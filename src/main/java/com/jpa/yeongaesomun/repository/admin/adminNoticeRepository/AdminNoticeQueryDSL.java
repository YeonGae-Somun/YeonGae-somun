package com.jpa.yeongaesomun.repository.admin.adminNoticeRepository;

import com.jpa.yeongaesomun.domain.entity.member.Enterprise;
import com.jpa.yeongaesomun.domain.entity.member.Search;
import com.jpa.yeongaesomun.domain.entity.member.User;
import com.jpa.yeongaesomun.domain.entity.notice.Notice;
import com.jpa.yeongaesomun.domain.entity.notice.NoticeDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface AdminNoticeQueryDSL {
    //찾기 서비스
    public Page<Notice> findAllWithPaging(Pageable pageable, Search search);

    //    이름 수정
    public void updateById(Notice notice);

    public void saveNoticeDTO(Notice notice);

    public Optional<NoticeDTO> findNoticeDTOById(Long id);

    //    상품 목록
    public List<Notice> findAll();

    //    이름으로 상품 삭제(이름은 포함이 아닌 같은 지 검사)
    public void deleteByAdminEnterpriseName(Long id);
}
