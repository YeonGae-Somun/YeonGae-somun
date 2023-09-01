package com.jpa.yeongaesomun.domain.entity.member;

import com.jpa.yeongaesomun.domain.audit.Period;
import com.jpa.yeongaesomun.domain.embeddable.Address;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@ToString
@Table(name = "TBL_STARTUP")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StartUp extends Period {

    @Id
    @GeneratedValue
    @EqualsAndHashCode.Include
    private Long id;

    @NotNull
    @Column(unique = true)
    private String sBusinessNumber;
    private String sBusinessName;
    private String sMajor;
    private String sManager;
    private Long sEmployeeCount;
    @Embedded
    private Address sAddress;
    private String sHomepage;
    private String sFoundingDate;

    @OneToOne(fetch = FetchType.LAZY)
    private User user;

    @Builder
    public StartUp(Long id, String sBusinessNumber, String sBusinessName, String sMajor, String sManager, Long sEmployeeCount, Address sAddress, String sHomepage, String sFoundingDate) {
        this.id=id;
        this.sBusinessNumber=sBusinessNumber;
        this.sBusinessName=sBusinessName;
        this.sMajor=sMajor;
        this.sManager=sManager;
        this.sEmployeeCount=sEmployeeCount;
        this.sAddress=sAddress;
        this.sHomepage=sHomepage;
        this.sFoundingDate=sFoundingDate;
    }
}
