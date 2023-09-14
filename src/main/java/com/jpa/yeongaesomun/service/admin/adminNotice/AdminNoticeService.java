package com.jpa.yeongaesomun.service.admin.adminNotice;

import com.jpa.yeongaesomun.domain.entity.member.Search;
import com.jpa.yeongaesomun.domain.entity.member.User;
import com.jpa.yeongaesomun.domain.entity.notice.Notice;
import com.jpa.yeongaesomun.domain.entity.notice.NoticeDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AdminNoticeService {
    public Page<Notice> getList(Pageable pageable, Search search);

    //    게시글 조회
    public Notice getNotice(Long id);

    public NoticeDTO getNoticeDTO(Long id);

    public void saveNoticeDTO(NoticeDTO noticeDTO);

    public void update(NoticeDTO notice);

    public void deleteAllById(List<Long> id);

    default Notice toEntity(Notice notice){
        return Notice.builder()
                .noticeTitle(notice.getNoticeTitle())
                .noticeContent(notice.getNoticeContent())
                .noticeWriter(notice.getNoticeWriter())
                .noticeReleaseDate(notice.getNoticeReleaseDate())
                .noticeUpdateDate(notice.getNoticeUpdateDate())
                .build();
    }
}
