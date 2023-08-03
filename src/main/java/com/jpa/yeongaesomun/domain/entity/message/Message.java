package com.jpa.yeongaesomun.domain.entity.message;

import com.jpa.yeongaesomun.domain.audit.Period;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBL_MESSAGE")
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DynamicInsert
@DynamicUpdate
public class Message extends Period {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Include
    private Long id;

    @NotNull
    private String messageContent;

    private Boolean isChecked;

    @Builder
    public Message(String messageContent){
        this.messageContent=messageContent;
        this.isChecked=false;
    }
}
