package com.jpa.yeongaesomun.entity.member;

import com.jpa.yeongaesomun.audit.Period;
import com.jpa.yeongaesomun.entity.embeddable.Address;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@ToString
@Table(name = "TBL_ENTERPRISE")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Enterprise extends Period {

    @Id
    @GeneratedValue
    @EqualsAndHashCode.Include
    private Long Id;

    @NotNull
    @Column(unique = true)
    private String eBusinessNumber;
    private String eMajor;
    private String eManager;
    private Long eEmployeeCount;
    @Embedded
    private Address eAddress;
    private String eHomepage;
    private String eFoundingDate;

    @OneToOne(fetch = FetchType.LAZY)
    private User user;


}
