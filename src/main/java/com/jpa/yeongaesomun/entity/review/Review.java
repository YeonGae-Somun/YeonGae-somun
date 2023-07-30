package com.jpa.yeongaesomun.entity.review;

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
public class Review {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull private String reviewTitle;
    @NotNull private String reviewContent;
    private LocalDateTime reviewRegisterDateTime;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "review")
    private List<ReviewFile> reviewFiles = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}
