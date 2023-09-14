package com.jpa.yeongaesomun.service.admin.adminNotice;

import com.jpa.yeongaesomun.domain.entity.member.Search;
import com.jpa.yeongaesomun.domain.entity.member.User;
import com.jpa.yeongaesomun.domain.entity.notice.Notice;
import com.jpa.yeongaesomun.domain.entity.notice.NoticeDTO;
import com.jpa.yeongaesomun.repository.admin.adminEnterpriseRepository.AdminEnterpriseRepository;
import com.jpa.yeongaesomun.repository.admin.adminNoticeRepository.AdminNoticeRepository;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Not;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminNoticeServiceImpl implements AdminNoticeService {
    private final AdminNoticeRepository adminNoticeRepository;

    @Override
    @Transactional
    public Page<Notice> getList(Pageable pageable, Search search) {
        return adminNoticeRepository.findAllWithPaging(pageable, search);
    }

    @Override
    @Transactional
    public Notice getNotice(Long id) {
        final Notice notice = toEntity(adminNoticeRepository.findById(id).orElseThrow(() ->{
            throw new RuntimeException();
        }));

        return notice;
    }

    @Override
    public NoticeDTO getNoticeDTO(Long id) {
        return adminNoticeRepository.findNoticeDTOById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    @Transactional
    public void saveNoticeDTO(NoticeDTO noticeDTO) {
        adminNoticeRepository.findById(noticeDTO.getId()).ifPresent(notice -> {
            notice.setNoticeTitle(noticeDTO.getNoticeTitle());
            notice.setNoticeContent(noticeDTO.getNoticeContent());
        });
    }



    @Override
    @Transactional
    public void update(NoticeDTO noticeDTO) {
        adminNoticeRepository.findById(noticeDTO.getId()).ifPresent(notice -> {
            notice.setNoticeTitle(noticeDTO.getNoticeTitle());
            notice.setNoticeContent(noticeDTO.getNoticeContent());
        });
    }

    @Override
    @Transactional
    public void deleteAllById(List<Long> ids) {
        adminNoticeRepository.deleteAllById(ids);
    }
}
