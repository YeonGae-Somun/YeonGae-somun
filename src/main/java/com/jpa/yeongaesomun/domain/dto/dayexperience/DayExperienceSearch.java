package com.jpa.yeongaesomun.domain.dto.dayexperience;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class DayExperienceSearch {
    private String dayExperienceTitle;
    private String dayExperienceContent;
    private Integer replyCount;
}
