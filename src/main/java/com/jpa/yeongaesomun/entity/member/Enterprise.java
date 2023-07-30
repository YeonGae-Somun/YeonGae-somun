package com.jpa.yeongaesomun.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter @ToString
@Table(name = "TBL_ENTERPRISE")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Enterprise {
    @Id
    @GeneratedValue
    @EqualsAndHashCode.Include
    private Long id;



}
