package com.jpa.yeongaesomun.domain.entity.introduce;

import com.jpa.yeongaesomun.domain.audit.Period;
import com.jpa.yeongaesomun.domain.entity.member.User;
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
