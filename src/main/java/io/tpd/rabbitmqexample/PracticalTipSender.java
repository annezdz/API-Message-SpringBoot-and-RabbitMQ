package io.tpd.rabbitmqexample;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.sql.Connection;

@Service
public class PracticalTipSender {

    private static final Logger log = LoggerFactory.getLogger(PracticalTipSender.class);

    private final RabbitTemplate rabbitTemplate;

    public PracticalTipSender(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Scheduled(fixedDelay = 9000L)
    public void sendPraticalTip(){
        PracticalTipMessage tip = new PracticalTipMessage("ALWAYS USE IMUTABLE CLASSES IN JAVA",1,false);
        rabbitTemplate.convertAndSend(RabbitmqExampleApplication.EXCHANGE_NAME, RabbitmqExampleApplication.ROUTING_KEY,tip);
        log.info("Practical Tip");
    }
}
