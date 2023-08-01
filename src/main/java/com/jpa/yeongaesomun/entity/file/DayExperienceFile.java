package com.jpa.yeongaesomun.entity.file;

import com.jpa.yeongaesomun.entity.dayexperience.DayExperience;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@ToString
@Table(name = "TBL_DAY_EXPERIENCE_FILE")
@PrimaryKeyJoinColumn(name = "FILE_ID")
public class DayExperienceFile extends File{


    @ManyToOne(fetch = FetchType.LAZY)
    private DayExperience dayExperience;

}
