package com.jpa.yeongaesomun.entity.file;

import com.jpa.yeongaesomun.entity.introduce.Introduce;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@ToString
@Getter
@Table(name = "TBL_USER_INTRODUCE_FILE")
@PrimaryKeyJoinColumn(name = "FILE_ID")
public class UserIntroduceFIle extends File{
    @ManyToOne(fetch = FetchType.LAZY)
    private Introduce introduce;
}
