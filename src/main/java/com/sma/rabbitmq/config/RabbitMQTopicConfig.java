package com.sma.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Author: Mak Sophea
 * Date: 07/31/2020
 */
@Configuration
public class RabbitMQTopicConfig {
    @Bean
    Queue marketingQueueTopic() {
        return new Queue("marketingQueueTopic", false);
    }

    @Bean
    Queue financeQueueTopic() {
        return new Queue("financeQueueTopic", false);
    }

    @Bean
    Queue adminQueueTopic() {
        return new Queue("adminQueueTopic", false);
    }

    @Bean
    Queue allQueueTopic() {
        return new Queue("allQueueTopic", false);
    }

    @Bean
    TopicExchange topicExchange() {
        return new TopicExchange("topic-exchange");
    }

    @Bean
    Binding marketingBindingTopic(Queue marketingQueueTopic, TopicExchange topicExchange) {
        return BindingBuilder.bind(marketingQueueTopic).to(topicExchange).with("queue.marketing");
    }

    @Bean
    Binding financeBindingTopic(Queue financeQueueTopic, TopicExchange topicExchange) {
        return BindingBuilder.bind(financeQueueTopic).to(topicExchange).with("queue.finance");
    }

    @Bean
    Binding adminBindingTopic(Queue adminQueueTopic, TopicExchange topicExchange) {
        return BindingBuilder.bind(adminQueueTopic).to(topicExchange).with("queue.admin");
    }

    @Bean
    Binding allBinding(Queue allQueueTopic, TopicExchange topicExchange) {
        return BindingBuilder.bind(allQueueTopic).to(topicExchange).with("queue.*");
    }
}
