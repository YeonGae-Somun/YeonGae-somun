package com.jpa.yeongaesomun.domain.entity.notice;

import com.jpa.yeongaesomun.domain.audit.Period;
import com.jpa.yeongaesomun.domain.entity.member.User;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@ToString
@Table(name = "TBL_NOTICE_BOARD")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Notice extends Period {
    @Id
    @GeneratedValue
    @EqualsAndHashCode.Include
    private Long id;

    @NotNull private String noticeTitle;
    @NotNull private String noticeContent;


    @ManyToOne(fetch = FetchType.LAZY)
    private User user;


    @Builder
    public Notice(@NotNull String noticeTitle, @NotNull String noticeContent) {
        this.noticeTitle = noticeTitle;
        this.noticeContent = noticeContent;

    }
}
