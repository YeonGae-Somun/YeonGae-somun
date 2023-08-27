package com.jpa.yeongaesomun.domain.dto.dayexperience;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class DayExperienceDTO {
    private Long id;
    private String dayExperienceTitle;
    private String dayExperienceContent;
    private Integer replyCount;

    @Builder
    public DayExperienceDTO(Long id, String dayExperienceTitle, String dayExperienceContent) {
        this.id = id;
        this.dayExperienceTitle = dayExperienceTitle;
        this.dayExperienceContent = dayExperienceContent;
    }
}
