package com.jpa.yeongaesomun.domain.entity.member;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class EnterpriseDTO {
    private Long id;
    private String eBusineesName;
    private String eManager;
    private Long eEmployeeCount;
    private String eContent;
}
