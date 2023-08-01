package com.jpa.yeongaesomun.entity.file;


import com.jpa.yeongaesomun.entity.review.Review;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter @ToString
@Table(name = "TBL_REVIEW_FILE")
@PrimaryKeyJoinColumn(name = "FILE_ID")
public class ReviewFile extends File{


    @ManyToOne(fetch = FetchType.LAZY)
    private Review review;
}
