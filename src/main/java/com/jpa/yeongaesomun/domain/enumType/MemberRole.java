package com.jpa.yeongaesomun.domain.enumType;

public enum MemberRole {
    USER,ADMIN;

    private static final String ROLE_PREFIX = "ROLE_";

    public String getSecurityRole(){
        return ROLE_PREFIX + name();
    }
}
