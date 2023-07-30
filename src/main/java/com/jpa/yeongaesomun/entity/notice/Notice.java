package com.jpa.yeongaesomun.entity.notice;

import com.jpa.yeongaesomun.entity.dayexperience.DayExperience;
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
public class Notice {
    @Id
    @GeneratedValue
    @EqualsAndHashCode.Include
    private Long id;

    @NotNull private String noticeTitle;
    @NotNull private String noticeContent;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "notice")
    private List<NoticeFile> noticeFiles = new ArrayList<>();

    @Builder
    public Notice(@NotNull String noticeTitle, @NotNull String noticeContent, LocalDateTime createdDate, LocalDateTime updatedDate) {
        this.noticeTitle = noticeTitle;
        this.noticeContent = noticeContent;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }
}
