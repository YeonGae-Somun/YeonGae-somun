package com.jpa.yeongaesomun.entity.qna;

import com.jpa.yeongaesomun.entity.member.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Getter @ToString @Setter
@Table(name = "TBL_QNA_RESPONSE")
public class QNAResponse {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull private String responseTitle;
    @NotNull private String responseContent;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    private QNA qna;
}
