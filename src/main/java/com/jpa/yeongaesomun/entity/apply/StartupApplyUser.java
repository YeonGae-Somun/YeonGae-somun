package com.jpa.yeongaesomun.entity.apply;

import com.jpa.yeongaesomun.entity.member.StartUp;
import com.jpa.yeongaesomun.entity.member.User;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "TBL_STARTUP_APPLY_USER")
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StartupApplyUser {
    @Id
    @GeneratedValue
    @EqualsAndHashCode.Include
    private Long id;
    private String applyStatusType;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    private StartUp startUp;

    @Builder

    public StartupApplyUser(String applyStatusType, User user, StartUp startUp) {
        this.applyStatusType = applyStatusType;
        this.user = user;
        this.startUp = startUp;
    }
}
