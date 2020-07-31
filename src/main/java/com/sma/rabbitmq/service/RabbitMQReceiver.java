package com.sma.rabbitmq.service;

import com.sma.rabbitmq.model.Category;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Author: Mak Sophea
 * Date: 07/31/2020
 */
@Component
@Slf4j
public class RabbitMQReceiver {

    @RabbitListener(queues = "${backend.rabbitmq.queue}")
    public void receivedMessage(Category category) {
        log.info("Recieved Message From RabbitMQ: " + category);
    }
}
