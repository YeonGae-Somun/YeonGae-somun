package com.jpa.yeongaesomun.entity.dayexperience;


import com.jpa.yeongaesomun.entity.member.Enterprise;
import com.jpa.yeongaesomun.entity.notice.Notice;
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
public class DayExperience {
    @Id
    @GeneratedValue
    @EqualsAndHashCode.Include
    private Long id;
    @NotNull private String dayExperienceExplnation;
    @NotNull private String dayExperienceCategory;
    @NotNull private String dayExperienceTitle;
    private LocalDateTime creationDate;
    private LocalDateTime updateDate;

    @ManyToOne(fetch = FetchType.LAZY)
    private Enterprise enterprise;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "dayExperience")
    private List<DayExperienceFile> dayExperienceFiles = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "dayExperience")
    private List<DayExperiencePartipant> dayExperiencePartipants = new ArrayList<>();

    @Builder
    public DayExperience(@NotNull String dayExperienceExplnation, @NotNull String dayExperienceCategory, @NotNull String dayExperienceTitle, LocalDateTime creationDate, LocalDateTime updateDate) {
        this.dayExperienceExplnation = dayExperienceExplnation;
        this.dayExperienceCategory = dayExperienceCategory;
        this.dayExperienceTitle = dayExperienceTitle;
        this.creationDate = creationDate;
        this.updateDate = updateDate;
    }
}
