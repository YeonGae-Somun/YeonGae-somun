package com.jpa.yeongaesomun.entity.member;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Getter @Setter
@ToString
@Table(name = "TBL_STARTUP")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@PrimaryKeyJoinColumn
public class StartUp extends User{

    private String sBusinessNumber;
    private String sIntroduction;
    private String sService;
    private String sManager;
    private String sEmployNumber;
    private String sAddress;
    private String sEmail;
    private String sHomepage;
    private String sCreationDate;
}
