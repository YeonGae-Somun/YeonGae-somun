package com.jpa.yeongaesomun.entity;

import com.jpa.yeongaesomun.entity.member.Enterprise;
import com.jpa.yeongaesomun.entity.member.StartUp;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "TBL_STARTUP_ENTERPRISE")
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StartUpEnterprise {
    @Id
    @GeneratedValue
    @EqualsAndHashCode.Include
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private StartUp startUp;

    @ManyToOne(fetch = FetchType.LAZY)
    private Enterprise enterprise;


}
