package com.jpa.yeongaesomun.entity.file;

import com.jpa.yeongaesomun.entity.dayexperience.DayExperience;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter @Setter @ToString
@Table(name = "TBL_DAY_EXPERIENCE_FILE")
public class DayExperienceFile extends File{


    @ManyToOne(fetch = FetchType.LAZY)
    private DayExperience dayExperience;

}
