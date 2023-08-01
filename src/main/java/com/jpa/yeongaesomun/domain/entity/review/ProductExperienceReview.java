package com.jpa.yeongaesomun.domain.entity.review;

import com.jpa.yeongaesomun.domain.entity.dayexperience.DayExperience;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "TBL_PRODUCT_E_REVIEW")
@PrimaryKeyJoinColumn(name = "REVIEW_ID")
public class ProductExperienceReview extends Review{

    @ManyToOne(fetch = FetchType.LAZY)
    private DayExperience dayExperience;


}
