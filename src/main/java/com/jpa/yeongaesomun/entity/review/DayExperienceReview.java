package com.jpa.yeongaesomun.entity.review;

import com.jpa.yeongaesomun.entity.dayexperience.DayExperience;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "TBL_DAY_E_REVIEW")
public class DayExperienceReview extends Review{

    @ManyToOne(fetch = FetchType.LAZY)
    private DayExperience dayExperience;


}
