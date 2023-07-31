package com.jpa.yeongaesomun.entity.apply;

import com.jpa.yeongaesomun.entity.member.Enterprise;
import com.jpa.yeongaesomun.entity.member.StartUp;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "TBL_ENTERPRISE_APPLY_STARTUP")
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class EnterpriseApplyStartUp {
    @Id
    @GeneratedValue
    @EqualsAndHashCode.Include
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private StartUp startUp;

    @ManyToOne(fetch = FetchType.LAZY)
    private Enterprise enterprise;


}
