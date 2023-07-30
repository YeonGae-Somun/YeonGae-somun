package com.jpa.yeongaesomun.entity.review;


import com.jpa.yeongaesomun.entity.review.Review;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter @Setter @ToString
@Table(name = "TBL_REVIEW_FILE")
public class ReviewFile {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Review review;
}
