package com.jpa.yeongaesomun.domain.entity.qna;

import com.jpa.yeongaesomun.domain.audit.Period;
import com.jpa.yeongaesomun.domain.entity.member.User;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter @ToString @Setter
@Table(name = "TBL_QNA_RESPONSE")
public class QNAResponse extends Period {
    @Id
    @GeneratedValue
    @EqualsAndHashCode.Include
    private Long id;

    @NotNull private String responseTitle;
    @NotNull private String responseContent;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}
