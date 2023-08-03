package com.jpa.yeongaesomun.repository.messageRepository;

import com.jpa.yeongaesomun.domain.entity.member.User;
import com.jpa.yeongaesomun.domain.entity.message.Message;
import com.jpa.yeongaesomun.domain.entity.message.MessageReceiver;
import com.jpa.yeongaesomun.domain.entity.message.QMessage;
import com.jpa.yeongaesomun.domain.entity.message.QMessageReceiver;
import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.JPQLQueryFactory;
import lombok.RequiredArgsConstructor;

import static com.jpa.yeongaesomun.domain.entity.message.QMessage.*;
import static com.jpa.yeongaesomun.domain.entity.message.QMessageReceiver.*;

@RequiredArgsConstructor
public class MessageQueryDSLImpl implements MessageQueryDSL{
    private final JPQLQueryFactory query;

    @Override
    public Long countAllNotIsCheckedByReceiverId(User user) {
        return query.select(messageReceiver.message.count())
                .from(messageReceiver)
                .where(messageReceiver.receiver.eq(user).and(messageReceiver.message.isChecked.eq(false))).fetchOne();
    }
}
