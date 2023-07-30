package com.jpa.yeongaesomun.entity;

import com.jpa.yeongaesomun.entity.member.User;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "TBL_USER_PROFILE_FILE")
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserProfileFile {
    @Id
    @GeneratedValue
    @EqualsAndHashCode.Include
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    private File file;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}
