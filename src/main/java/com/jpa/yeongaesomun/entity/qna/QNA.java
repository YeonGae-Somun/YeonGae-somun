package com.jpa.yeongaesomun.entity.qna;

import com.jpa.yeongaesomun.audit.Period;
import com.jpa.yeongaesomun.entity.member.User;
import com.jpa.yeongaesomun.entity.review.Review;
import com.jpa.yeongaesomun.enumType.ResponseStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
