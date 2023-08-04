package com.jpa.yeongaesomun.domain.dto.introduce;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class IntroduceDTO {
    private Long id;
    private String introduceTitle;
    private String introduceContent;

    @Builder
    public IntroduceDTO(Long id, String introduceTitle, String introduceContent) {
        this.id = id;
        this.introduceTitle = introduceTitle;
        this.introduceContent = introduceContent;
    }
}
