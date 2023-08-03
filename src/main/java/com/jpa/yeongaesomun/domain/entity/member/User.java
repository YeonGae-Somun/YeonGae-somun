package com.jpa.yeongaesomun.domain.entity.member;

import com.jpa.yeongaesomun.domain.audit.Period;
import com.jpa.yeongaesomun.domain.entity.message.MessageReceiver;
import com.jpa.yeongaesomun.domain.enumType.MemberLoginType;
import com.jpa.yeongaesomun.domain.enumType.MemberRole;
import com.jpa.yeongaesomun.domain.enumType.MemberStatus;
import com.jpa.yeongaesomun.domain.enumType.MemberType;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

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

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "receiver")
    private List<MessageReceiver> messageReceivers;


    @Builder
    public User( String userEmail, String userPassword, String userNickname,MemberLoginType memberLoginType,MemberRole memberRole,MemberStatus memberStatus
                ,MemberType memberType) {
        this.userEmail=userEmail;
        this.userPassword=userPassword;
        this.userNickname=userNickname;
        this.userLoginType =memberLoginType;
        this.userRole=memberRole;
        this.userStatus=memberStatus;
        this.userType=memberType;
    }



}
