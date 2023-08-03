package com.jpa.yeongaesomun.repository.messageRepository;

import com.jpa.yeongaesomun.domain.entity.message.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message,Long>,MessageQueryDSL {

}
