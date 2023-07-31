package com.jpa.yeongaesomun.entity.file;

import com.jpa.yeongaesomun.entity.introduce.Introduce;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@ToString
@Getter
@Table(name = "TBL_USER_INTRODUCE_FILE")
public class UserIntroduceFIle extends File{
    @ManyToOne(fetch = FetchType.LAZY)
    private Introduce introduce;
}
