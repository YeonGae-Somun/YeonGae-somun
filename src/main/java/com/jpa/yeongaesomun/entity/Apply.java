package com.jpa.yeongaesomun.entity;

import com.jpa.yeongaesomun.entity.member.StartUp;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "TBL_APPLY")
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Apply {
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

    public Apply(String applyStatusType, User user, StartUp startUp) {
        this.applyStatusType = applyStatusType;
        this.user = user;
        this.startUp = startUp;
    }
}
