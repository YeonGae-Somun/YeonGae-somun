package com.jpa.yeongaesomun.entity.introduce;

import com.jpa.yeongaesomun.audit.Period;
import com.jpa.yeongaesomun.entity.member.User;
import com.jpa.yeongaesomun.enumType.MemberLoginType;
import com.jpa.yeongaesomun.enumType.MemberRole;
import com.jpa.yeongaesomun.enumType.MemberStatus;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Table(name = "TBL_INTRODUCE_BOARD")
@NoArgsConstructor(access = AccessLevel.PROTECTED)

public class Introduce extends Period {
    @Id
    @GeneratedValue
    @EqualsAndHashCode.Include
    private Long Id;
    @NotNull
    private String introduceBoardTitle;
    @NotNull
    private String introduceBoardContent;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

}
