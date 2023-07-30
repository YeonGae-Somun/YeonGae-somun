package com.jpa.yeongaesomun.entity.notice;

import com.jpa.yeongaesomun.entity.dayexperience.DayExperience;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter @Setter @ToString
@Table(name = "TBL_NOTICE_FILE")
public class NoticeFile {
    @Id
    @GeneratedValue
    @EqualsAndHashCode.Include
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Notice notice;
}
