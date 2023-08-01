package com.jpa.yeongaesomun.domain.entity.message;

import com.jpa.yeongaesomun.domain.audit.Period;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBL_MESSAGE")
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Message extends Period {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Include
    private Long id;

    @NotNull
    private String messageContent;


}
