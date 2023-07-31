package com.jpa.yeongaesomun.entity.review;

import com.jpa.yeongaesomun.audit.Period;
import com.jpa.yeongaesomun.entity.file.ReviewFile;
import com.jpa.yeongaesomun.entity.member.User;
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
@Table(name = "TBL_REVIEW_BOARD")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "RIVIEW_TYPE")
public class Review extends Period {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull private String reviewTitle;
    @NotNull private String reviewContent;
    @NotNull private String experienceDate;



    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}
