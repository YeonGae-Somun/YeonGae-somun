package com.jpa.yeongaesomun.entity.member;

import com.jpa.yeongaesomun.audit.Period;
import com.jpa.yeongaesomun.enumType.MemberLoginType;
import com.jpa.yeongaesomun.enumType.MemberRole;
import com.jpa.yeongaesomun.enumType.MemberStatus;
import com.jpa.yeongaesomun.enumType.MemberType;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBL_USER",
        uniqueConstraints = {
        @UniqueConstraint(columnNames = {"userEmail"}),
        @UniqueConstraint(columnNames = {"userNickname"})})
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends Period {

    @Id
    @GeneratedValue
    @EqualsAndHashCode.Include
    private Long Id;
    @NotNull
    private String userEmail;
    @NotNull
    private String userPassword;
    @NotNull
    private String userNickname;

    @Enumerated(EnumType.STRING)
    private MemberLoginType userLoginType;
    @Enumerated(EnumType.STRING)
    private MemberRole userRole;
    @Enumerated(EnumType.STRING)
    private MemberStatus userStatus;
    @Enumerated(EnumType.STRING)
    private MemberType userType;






}
