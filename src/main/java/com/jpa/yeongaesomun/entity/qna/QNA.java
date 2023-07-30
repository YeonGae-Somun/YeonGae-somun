package com.jpa.yeongaesomun.entity.qna;

import com.jpa.yeongaesomun.entity.member.User;
import com.jpa.yeongaesomun.entity.review.Review;
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
public class QNA {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull private String QNATitle;
    @NotNull private String QNAContent;
    private LocalDateTime CreateDate;
    private LocalDateTime updateDate;
    @NotNull private String responseStatus;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "qna")
    private List<QNAResponse> qnaResponses = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}
