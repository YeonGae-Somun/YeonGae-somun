package com.jpa.yeongaesomun.domain.entity.member;

import com.jpa.yeongaesomun.domain.audit.Period;
import com.jpa.yeongaesomun.domain.embeddable.Address;
import com.jpa.yeongaesomun.domain.enumType.*;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@ToString @Setter
@Table(name = "TBL_ENTERPRISE")
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Enterprise extends Period {

    @Id
    @GeneratedValue
    @EqualsAndHashCode.Include
    private Long id;

    @NotNull
    @Column(unique = true)
    private String eBusinessNumber;
    private String eBusineesName;
    private String eMajor;
    private String eManager;
    private Long eEmployeeCount;
    private String eLocation;
    private String eContent;
    @Embedded
    private Address eAddress;
    private String eHomepage;
    private String eFoundingDate;

    @OneToOne(fetch = FetchType.LAZY)
    private User user;

    @Builder
    public Enterprise(Long id, String eBusinessNumber, String eBusineesName, String eMajor, String eManager, Long eEmployeeCount, String eLocation, String eContent, Address eAddress, String eHomepage, String eFoundingDate) {
        this.id=id;
        this.eBusinessNumber=eBusinessNumber;
        this.eBusineesName=eBusineesName;
        this.eMajor=eMajor;
        this.eManager=eManager;
        this.eEmployeeCount=eEmployeeCount;
        this.eLocation=eLocation;
        this.eContent=eContent;
        this.eAddress=eAddress;
        this.eHomepage=eHomepage;
        this.eFoundingDate=eFoundingDate;
    }
}
