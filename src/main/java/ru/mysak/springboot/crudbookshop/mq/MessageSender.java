package ru.mysak.springboot.crudbookshop.mq;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import ru.mysak.springboot.crudbookshop.entity.Orders;

@Service
public class MessageSender {

    private final JmsTemplate jmsTemplate;
    private final String send;

    public MessageSender(JmsTemplate jmsTemplate, @Value("${my.mq}") String send) {
        this.jmsTemplate = jmsTemplate;
        this.send = send;
    }

    public void sendMessage(String msg) {
        jmsTemplate.convertAndSend(send, new MessageBody(msg, "report about orders MQ"));
    }
}
