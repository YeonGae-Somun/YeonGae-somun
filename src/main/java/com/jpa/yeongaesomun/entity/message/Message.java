package com.jpa.yeongaesomun.entity.message;

import com.jpa.yeongaesomun.audit.Period;
import lombok.*;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

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
