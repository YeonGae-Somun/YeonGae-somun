package com.jpa.yeongaesomun.entity.file;

import com.jpa.yeongaesomun.entity.member.User;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "TBL_USER_PROFILE_FILE")
@Getter
@ToString
@PrimaryKeyJoinColumn(name = "FILE_ID")
public class UserProfileFile extends File{

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}
