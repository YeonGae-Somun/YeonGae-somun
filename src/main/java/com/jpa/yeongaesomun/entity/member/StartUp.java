package com.jpa.yeongaesomun.entity.member;

import com.jpa.yeongaesomun.entity.StartUpEnterprise;
import com.jpa.yeongaesomun.entity.productExperience.ProductExperience;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "startUp")
    private List<StartUpEnterprise> startUpEnterprises = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "startUp")
    private List<ProductExperience> productExperiences = new ArrayList<>();

}
