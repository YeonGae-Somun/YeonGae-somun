package com.jpa.yeongaesomun.entity.member;

import com.jpa.yeongaesomun.audit.Period;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

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

}
