package com.jpa.yeongaesomun.domain.entity.member;

import com.jpa.yeongaesomun.domain.audit.Period;
import com.jpa.yeongaesomun.domain.entity.message.MessageReceiver;
import com.jpa.yeongaesomun.domain.enumType.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "TBL_USER",
        uniqueConstraints = {
        @UniqueConstraint(columnNames = {"userEmail"}),
        @UniqueConstraint(columnNames = {"userNickname"})})
@Getter @Setter
@ToString
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class User extends Period {

    @Id
    @GeneratedValue
    @EqualsAndHashCode.Include
    private Long id;
    @NotNull
    private String userEmail;
    private String userPassword;
    private String userNickname;
    @NotNull
    private String userName;
    @NotNull
    private String userCellPhone;
    private LocalDate userBirthDate;
    private LocalDateTime userReleaseDate;

    @Enumerated(EnumType.STRING)
    private MemberGender userGender;

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
    public User(Long id, String userEmail, String userPassword, String userNickname, String userCellPhone, LocalDate userBirthDate, LocalDateTime userReleaseDate, String userName, MemberGender memberGender, MemberLoginType memberLoginType,MemberRole memberRole,MemberStatus memberStatus
                ,MemberType memberType) {
        this.id=id;
        this.userEmail=userEmail;
        this.userNickname=userNickname;
        this.userCellPhone=userCellPhone;
        this.userBirthDate=userBirthDate;
        this.userReleaseDate=userReleaseDate;
        this.userName = userName;
        this.userGender=memberGender;
        this.userLoginType =memberLoginType;
        this.userRole=memberRole;
        this.userStatus=memberStatus;
        this.userType=memberType;
    }
    public void setUserNickname(String memberName) {
        this.userNickname = memberName;
    }


    public void setUserEmail(String memberEmail) {
        this.userEmail = memberEmail;
    }


    public User update(String memberName,  String memberEmail){
        this.setUserNickname(memberName);
        this.setUserEmail(memberEmail);
        return this;
    }

}
