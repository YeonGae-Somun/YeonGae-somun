package com.jpa.yeongaesomun.entity.file;

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

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}
