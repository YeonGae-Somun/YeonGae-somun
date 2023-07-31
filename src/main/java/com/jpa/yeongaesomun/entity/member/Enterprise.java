package com.jpa.yeongaesomun.entity.member;

import com.jpa.yeongaesomun.entity.dayexperience.DayExperience;
import com.jpa.yeongaesomun.entity.notice.Notice;
import com.jpa.yeongaesomun.entity.StartUpEnterprise;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "enterprise")
    private List<DayExperience> dayExperiences = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "enterprise")
    private List<StartUpEnterprise> startUpEnterprises = new ArrayList<>();

}
