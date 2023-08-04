package com.jpa.yeongaesomun.domain.dto.introduce;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class IntroduceSearch {
    private String introduceTitle;
    private String introduceContent;
}
