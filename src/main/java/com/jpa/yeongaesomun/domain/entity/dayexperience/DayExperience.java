package com.jpa.yeongaesomun.domain.entity.dayexperience;


import com.jpa.yeongaesomun.domain.audit.Period;
import com.jpa.yeongaesomun.domain.entity.member.Enterprise;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter @ToString
@Table(name = "TBL_DAY_EXPERIENCE")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DayExperience extends Period {
    @Id
    @GeneratedValue
    @EqualsAndHashCode.Include
    private Long id;
    @NotNull private String dayExperienceContent;
    @NotNull private String dayExperienceCategory;
    @NotNull private String dayExperienceTitle;

    @ManyToOne(fetch = FetchType.LAZY)
    private Enterprise enterprise;

    @Builder
    public DayExperience(@NotNull String dayExperienceContent, @NotNull String dayExperienceCategory, @NotNull String dayExperienceTitle) {
        this.dayExperienceContent = dayExperienceContent;
        this.dayExperienceCategory = dayExperienceCategory;
        this.dayExperienceTitle = dayExperienceTitle;
    }
}
