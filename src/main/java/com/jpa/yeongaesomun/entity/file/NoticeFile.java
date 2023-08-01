package com.jpa.yeongaesomun.entity.file;

import com.jpa.yeongaesomun.entity.dayexperience.DayExperience;
import com.jpa.yeongaesomun.entity.notice.Notice;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@ToString
@Table(name = "TBL_NOTICE_FILE")
@PrimaryKeyJoinColumn(name = "FILE_ID")
public class NoticeFile extends File{

    @ManyToOne(fetch = FetchType.LAZY)
    private Notice notice;
}
