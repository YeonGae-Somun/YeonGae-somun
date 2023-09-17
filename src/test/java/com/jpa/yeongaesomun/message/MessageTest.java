package com.jpa.yeongaesomun.message;


import com.jpa.yeongaesomun.domain.entity.member.User;
import com.jpa.yeongaesomun.domain.entity.message.Message;
import com.jpa.yeongaesomun.domain.entity.message.MessageReceiver;
import com.jpa.yeongaesomun.domain.entity.message.MessageSender;
import com.jpa.yeongaesomun.domain.enumType.MemberLoginType;
import com.jpa.yeongaesomun.domain.enumType.MemberRole;
import com.jpa.yeongaesomun.domain.enumType.MemberStatus;
import com.jpa.yeongaesomun.domain.enumType.MemberType;
import com.jpa.yeongaesomun.repository.memberRepository.MemberRepository;
import com.jpa.yeongaesomun.repository.messageRepository.MessageReceiverRepository;
import com.jpa.yeongaesomun.repository.messageRepository.MessageRepository;
import com.jpa.yeongaesomun.repository.messageRepository.MessageSenderRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Slf4j
@Transactional
@Rollback(value = false)
public class MessageTest {
    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MessageReceiverRepository messageReceiverRepository;
    @Autowired
    private MessageSenderRepository messageSenderRepository;


    @Test
    public void messageTest(){
        //유저 추가
//        for (int i=0;i<100 ;i++){
//            User user = User.builder()
//                    .userEmail("u"+(i+2))
//                    .userNickname("u"+(i+2))
//                    .userPassword("u"+(i+2))
//                    .memberLoginType(MemberLoginType.EMAIL)
//                    .memberRole(MemberRole.USER)
//                    .memberStatus(MemberStatus.NORMAL)
//                    .memberType(MemberType.USER)
//                    .build();
//
//            memberRepository.save(user);
//        }

        //메시지 추가

//        User user1 = memberRepository.findById(1L).get();
//        User user2 = memberRepository.findById(2L).get();
//        User user3 = memberRepository.findById(3L).get();
//        for(int i = 0;i<100;i++){
//
//            Message message = Message.builder()
//                    .messageContent("message"+(i+1))
//                    .build();
//            MessageSender messageSender = MessageSender.builder()
//                    .sender(user1)
//                    .message(message)
//                    .build();
//            MessageReceiver messageReceiver = MessageReceiver.builder()
//                    .receiver(user2)
//                    .message(message)
//                    .build();
//
//            messageRepository.save(message);
//            messageReceiverRepository.save(messageReceiver);
//            messageSenderRepository.save(messageSender);

//        }

        //확인하지 않은 메세지 개수 세기
//        log.info(messageRepository.countAllNotIsCheckedByReceiverId(memberRepository.findById(2L).get()).toString());


    }


}
