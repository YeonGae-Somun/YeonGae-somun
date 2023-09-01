package com.jpa.yeongaesomun.domain.entity.member;

import lombok.Data;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@Data @ToString
public class Search {
    private String type;
    private String keyword;
}
