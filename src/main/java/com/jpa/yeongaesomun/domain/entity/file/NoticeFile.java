package com.jpa.yeongaesomun.domain.entity.file;

import com.jpa.yeongaesomun.domain.entity.notice.Notice;
import lombok.Getter;
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
