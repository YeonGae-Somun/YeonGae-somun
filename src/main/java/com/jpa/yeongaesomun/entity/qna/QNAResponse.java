package com.jpa.yeongaesomun.entity.qna;

import com.jpa.yeongaesomun.audit.Period;
import com.jpa.yeongaesomun.entity.member.User;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

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
