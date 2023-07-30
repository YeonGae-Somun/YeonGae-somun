package com.jpa.yeongaesomun.entity.member;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter @ToString
@Table(name = "TBL_ENTERPRISE")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@PrimaryKeyJoinColumn
public class Enterprise extends User{

    private String eBusinessNumber;
    private String eEmployNumber;
    private String eCreationDate;
    private String eAddress;
    private String eMajorBusiness;
    private String eCapital;
    private String eHomepage;

}
