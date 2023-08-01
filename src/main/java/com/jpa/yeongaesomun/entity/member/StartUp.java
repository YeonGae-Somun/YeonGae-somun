package com.jpa.yeongaesomun.entity.member;

import com.jpa.yeongaesomun.audit.Period;
import com.jpa.yeongaesomun.embeddable.Address;
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
    private Long Id;

    @NotNull
    @Column(unique = true)
    private String sBusinessNumber;
    private String sMajor;
    private String sManager;
    private Long sEmployeeCount;
    @Embedded
    private Address sAddress;
    private String sHomepage;
    private String sFoundingDate;

    @OneToOne(fetch = FetchType.LAZY)
    private User user;


}
