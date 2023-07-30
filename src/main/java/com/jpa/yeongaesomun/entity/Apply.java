package com.jpa.yeongaesomun.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

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
}
