package com.jpa.yeongaesomun.entity.dayexperience;

import com.jpa.yeongaesomun.audit.Period;
import com.jpa.yeongaesomun.entity.member.StartUp;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter @Setter @ToString
@Table(name = "TBL_DAY_EXPERIENCE_PARTICIPANT")
public class DayExperienceParticipants extends Period {
    @Id
    @GeneratedValue
    @EqualsAndHashCode.Include
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private StartUp startUp;

    @ManyToOne(fetch = FetchType.LAZY)
    private DayExperience dayExperience;

}
