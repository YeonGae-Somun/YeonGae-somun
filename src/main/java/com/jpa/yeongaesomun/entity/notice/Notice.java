package com.jpa.yeongaesomun.entity.notice;

import com.jpa.yeongaesomun.audit.Period;
import com.jpa.yeongaesomun.entity.file.NoticeFile;
import com.jpa.yeongaesomun.entity.member.User;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
