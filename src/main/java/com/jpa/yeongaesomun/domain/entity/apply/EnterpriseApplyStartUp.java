package com.jpa.yeongaesomun.domain.entity.apply;

import com.jpa.yeongaesomun.domain.audit.Period;
import com.jpa.yeongaesomun.domain.entity.member.Enterprise;
import com.jpa.yeongaesomun.domain.entity.member.StartUp;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "TBL_ENTERPRISE_APPLY_STARTUP")
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class EnterpriseApplyStartUp extends Period {
    @Id
    @GeneratedValue
    @EqualsAndHashCode.Include
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private StartUp startUp;

    @ManyToOne(fetch = FetchType.LAZY)
    private Enterprise enterprise;


}
