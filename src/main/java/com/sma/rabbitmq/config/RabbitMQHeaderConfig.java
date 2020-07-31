package com.sma.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.HeadersExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Author: Mak Sophea
 * Date: 07/31/2020
 */
@Configuration
public class RabbitMQHeaderConfig {

    @Bean
    Queue marketingQueueHeader() {
        return new Queue("marketingQueueHeader", false);
    }

    @Bean
    Queue financeQueueHeader() {
        return new Queue("financeQueueHeader", false);
    }

    @Bean
    Queue adminQueueHeader() {
        return new Queue("adminQueueHeader", false);
    }

    @Bean
    HeadersExchange headerExchange() {
        return new HeadersExchange("header-exchange");
    }

    @Bean
    Binding marketingBindingHeader(Queue marketingQueueHeader, HeadersExchange headerExchange) {
        return BindingBuilder.bind(marketingQueueHeader).to(headerExchange).where("department").matches("marketing");
    }

    @Bean
    Binding financeBindingHeader(Queue financeQueueHeader, HeadersExchange headerExchange) {
        return BindingBuilder.bind(financeQueueHeader).to(headerExchange).where("department").matches("finance");
    }

    @Bean
    Binding adminBindingHeader(Queue adminQueueHeader, HeadersExchange headerExchange) {
        return BindingBuilder.bind(adminQueueHeader).to(headerExchange).where("department").matches("admin");
    }
}
