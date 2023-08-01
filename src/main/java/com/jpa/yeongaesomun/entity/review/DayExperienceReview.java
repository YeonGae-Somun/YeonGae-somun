package com.jpa.yeongaesomun.entity.review;

import com.jpa.yeongaesomun.entity.dayexperience.DayExperience;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "TBL_DAY_E_REVIEW")
@PrimaryKeyJoinColumn(name = "REVIEW_ID")
public class DayExperienceReview extends Review{

    @ManyToOne(fetch = FetchType.LAZY)
    private DayExperience dayExperience;


}
