package ru.mysak.springboot.crudbookshop.mq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MessageListener {

    @JmsListener(destination = "bookshop")
    public void processMyMq(@Payload MessageBody messageBody) {
        log.info("Received report: {}", messageBody);
    }
}
