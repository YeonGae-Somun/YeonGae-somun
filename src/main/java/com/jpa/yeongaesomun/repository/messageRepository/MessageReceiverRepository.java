package com.jpa.yeongaesomun.repository.messageRepository;

import com.jpa.yeongaesomun.domain.entity.message.MessageReceiver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageReceiverRepository extends JpaRepository<MessageReceiver,Long> {
}
