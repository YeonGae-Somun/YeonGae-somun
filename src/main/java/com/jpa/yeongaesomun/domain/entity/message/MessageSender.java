package com.jpa.yeongaesomun.domain.entity.message;


import com.jpa.yeongaesomun.domain.entity.member.User;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "TBL_Message_Sender")
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MessageSender {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Include
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User sender;

    @OneToOne(fetch = FetchType.LAZY)
    private Message message;
}

