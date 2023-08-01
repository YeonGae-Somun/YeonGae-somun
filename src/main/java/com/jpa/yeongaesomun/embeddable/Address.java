package com.jpa.yeongaesomun.embeddable;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.Embeddable;

@Embeddable
@ToString
@Getter
public class Address {
    private String address;
    private String addressDetail;
    private String postcode;
}
