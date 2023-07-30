package com.jpa.yeongaesomun.entity.member;

import com.jpa.yeongaesomun.audit.Period;
import com.jpa.yeongaesomun.entity.Apply;
import com.jpa.yeongaesomun.entity.UserProfileFile;
import com.jpa.yeongaesomun.entity.productExperience.ProductExperienceParticipant;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TBL_USER")
@Getter @Setter
@ToString
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn
public class User extends Period {

    @Id
    @GeneratedValue
    private long Id;
    private String UserNickname;
    private String UserPassword;
    private String UserLoginType;
    private String UserEmail;
    private String UserType;
    private String UserRole;
    private String UserStatus;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "user")
    private List<Apply> applies = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY)
    private ProductExperienceParticipant productExperienceParticipant;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE,mappedBy = "user")
    private List<UserProfileFile> userProfileFiles = new ArrayList<>();

}
