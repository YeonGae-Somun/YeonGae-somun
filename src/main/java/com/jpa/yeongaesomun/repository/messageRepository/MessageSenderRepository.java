package com.jpa.yeongaesomun.repository.messageRepository;

import com.jpa.yeongaesomun.domain.entity.message.MessageSender;
import org.eclipse.jdt.internal.compiler.ast.MessageSend;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageSenderRepository extends JpaRepository<MessageSender,Long> {
}
