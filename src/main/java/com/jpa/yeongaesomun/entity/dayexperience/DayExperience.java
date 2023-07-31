package com.jpa.yeongaesomun.entity.dayexperience;


import com.jpa.yeongaesomun.audit.Period;
import com.jpa.yeongaesomun.entity.file.DayExperienceFile;
import com.jpa.yeongaesomun.entity.member.Enterprise;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
