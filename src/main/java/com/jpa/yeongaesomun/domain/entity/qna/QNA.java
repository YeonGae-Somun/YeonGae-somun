package com.jpa.yeongaesomun.domain.entity.qna;

import com.jpa.yeongaesomun.domain.audit.Period;
import com.jpa.yeongaesomun.domain.entity.member.User;
import com.jpa.yeongaesomun.domain.enumType.ResponseStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter @Setter @ToString
@Table(name = "TBL_QNA_BOARD")
public class QNA extends Period {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull private String qnaTitle;
    @NotNull private String qnaContent;

    @Enumerated(EnumType.STRING)
    @NotNull private ResponseStatus responseStatus;


    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}
