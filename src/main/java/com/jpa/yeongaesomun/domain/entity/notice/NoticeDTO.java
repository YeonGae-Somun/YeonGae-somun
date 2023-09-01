package com.jpa.yeongaesomun.domain.entity.notice;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@Data
@NoArgsConstructor
public class NoticeDTO {
    private Long id;

    private String noticeTitle;
    private String noticeContent;
}
