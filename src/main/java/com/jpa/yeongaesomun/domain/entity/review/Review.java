package com.jpa.yeongaesomun.domain.entity.review;

import com.jpa.yeongaesomun.domain.audit.Period;
import com.jpa.yeongaesomun.domain.entity.member.User;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter @Setter @ToString
@Table(name = "TBL_REVIEW_BOARD")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "RIVIEW_TYPE")
public class Review extends Period {
    @Id
    @GeneratedValue
    @EqualsAndHashCode.Include
    private Long id;

    @NotNull private String reviewTitle;
    @NotNull private String reviewContent;
    @NotNull private String experienceDate;



    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}
