package com.jpa.yeongaesomun.repository.messageRepository;

import com.jpa.yeongaesomun.domain.entity.member.User;
import com.jpa.yeongaesomun.domain.entity.message.Message;
import com.jpa.yeongaesomun.domain.entity.message.MessageReceiver;
import com.querydsl.jpa.JPQLQuery;

public interface MessageQueryDSL {
    //receiver와 조인해서 전체 읽지 않은 갯수 가져오기
    public Long countAllNotIsCheckedByReceiverId(User user);
}
