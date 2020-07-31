package com.sma.rabbitmq.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Author: Mak Sophea
 * Date: 07/31/2020
 */
@Slf4j
@Configuration
public class RabbitMQFanoutConfig {

    @Bean
    Queue marketingQueueFanout() {
        return new Queue("marketingQueue-f", false);
    }

    @Bean
    Queue financeQueueFanout() {
        return new Queue("financeQueue-f", false);
    }

    @Bean
    Queue adminQueueFanout() {
        return new Queue("adminQueue-f", false);
    }

    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange("fanout-exchange");
    }

    @Bean
    Binding marketingBindingFanout(Queue marketingQueueFanout, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(marketingQueueFanout).to(fanoutExchange);
    }

    @Bean
    Binding financeBindingFanout(Queue financeQueueFanout, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(financeQueueFanout).to(fanoutExchange);
    }

    @Bean
    Binding adminBindingFanout(Queue adminQueueFanout, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(adminQueueFanout).to(fanoutExchange);
    }
}
