package com.jpa.yeongaesomun.entity.dayexperience;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter @Setter @ToString
@Table(name = "TBL_DAY_EXPERIENCE_PARTICIPANT")
public class DayExperienceFile {
    @Id
    @GeneratedValue
    @EqualsAndHashCode.Include
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private DayExperience dayExperience;

}
