package com.jpa.yeongaesomun.domain.entity.notice;

import com.jpa.yeongaesomun.domain.audit.Period;
import com.jpa.yeongaesomun.domain.entity.member.User;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@ToString @Setter
@Table(name = "TBL_NOTICE_BOARD")
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Notice extends Period {
    @Id
    @GeneratedValue
    @EqualsAndHashCode.Include
    private Long id;

    @NotNull private String noticeTitle;
    @NotNull private String noticeContent;
    private String noticeWriter;
    private LocalDateTime noticeReleaseDate;
    private LocalDate noticeUpdateDate;


    @ManyToOne(fetch = FetchType.LAZY)
    private User user;


    @Builder
    public Notice(@NotNull String noticeTitle, @NotNull String noticeContent, String noticeWriter, LocalDateTime noticeReleaseDate, LocalDate noticeUpdateDate) {
        this.noticeTitle = noticeTitle;
        this.noticeContent = noticeContent;
        this.noticeWriter = noticeWriter;
        this.noticeReleaseDate = noticeReleaseDate;
        this.noticeUpdateDate = noticeUpdateDate;
    }
}
