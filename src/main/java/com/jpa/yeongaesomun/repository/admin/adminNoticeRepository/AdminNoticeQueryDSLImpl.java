package com.jpa.yeongaesomun.repository.admin.adminNoticeRepository;

import com.jpa.yeongaesomun.domain.entity.member.Enterprise;
import com.jpa.yeongaesomun.domain.entity.member.Search;
import com.jpa.yeongaesomun.domain.entity.notice.Notice;
import com.jpa.yeongaesomun.domain.entity.notice.NoticeDTO;
import com.jpa.yeongaesomun.domain.entity.notice.QNotice;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

import static com.jpa.yeongaesomun.domain.entity.member.QEnterprise.enterprise;
import static com.jpa.yeongaesomun.domain.entity.member.QUser.user;
import static com.jpa.yeongaesomun.domain.entity.notice.QNotice.notice;

@RequiredArgsConstructor
public class AdminNoticeQueryDSLImpl implements AdminNoticeQueryDSL {
    private final JPAQueryFactory query;

    @Override
    public Page<Notice> findAllWithPaging(Pageable pageable, Search search) {
        BooleanExpression noticeContains = null;

        if(search.getType() != null && search.getKeyword() != null) {
            if(search.getType().equals("noticetitle")) {
                noticeContains = notice.noticeTitle.contains(search.getKeyword());
            }
            else if(search.getType().equals("noticewriter")) {
                noticeContains = notice.noticeWriter.contains(search.getKeyword());
            }
        }

        final List<Notice> notices = query.select (
                Projections.fields(
                        Notice.class,
                        notice.id,
                        notice.noticeTitle,
                        notice.noticeContent,
                        notice.noticeWriter,
                        notice.noticeReleaseDate,
                        notice.noticeUpdateDate
                )
        ).from(notice)
                .orderBy(notice.id.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .where(noticeContains)
                .fetch();

        final Long count = query.select(notice.count()).from(notice).fetchOne();

        return new PageImpl<>(notices, pageable, count);
    }

    @Override
    public void updateById(Notice notice) {
        query.update(QNotice.notice).set(QNotice.notice.noticeTitle, notice.getNoticeTitle())
                .set(QNotice.notice.noticeContent, notice.getNoticeContent())
                .where(QNotice.notice.id.eq(notice.getId())).execute();
    }

    @Override
    public void saveNoticeDTO(Notice notice) {
        query.insert(QNotice.notice).set(QNotice.notice.noticeTitle, notice.getNoticeTitle())
                .set(QNotice.notice.noticeContent, notice.getNoticeContent());
    }

    @Override
    public Optional<NoticeDTO> findNoticeDTOById(Long id) {
        return Optional.ofNullable(query.select(
                Projections.fields(
                        NoticeDTO.class,
                        notice.id,
                        notice.noticeTitle,
                        notice.noticeContent

                )
        ).from(notice)
                .where(notice.id.eq(id)).fetchOne());
    }

    @Override
    public List<Notice> findAll() {
        final List<Notice> notices = query.select(notice).from(notice).fetch();
        return notices;
    }

    @Override
    public void deleteByAdminEnterpriseName(Long id) {
        query.delete(notice).where(notice.id.eq(id)).execute();
    }
}
