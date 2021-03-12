package com.onway.poseidon.web.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: fuheng
 * @date: 2021/3/5 11:16
 * @description:
 */
@Configuration
public class TopicConfig {

    //队列名称
    public static final String QUEUE_NAME = "jd_goods_topic_queue";

    //交换器名称
    public static final String EXCHANGE_NAME = "jd_goods_topic_exchange";

    @Bean
    public Queue queueTopic() {
        return new Queue(TopicConfig.QUEUE_NAME);
    }

    //配置交换器
    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(TopicConfig.EXCHANGE_NAME);
    }

    //绑定队列到交换器，并设置路由键（jd_goods.#）
    @Bean
    public Binding bindingtopicExchangeQueue(Queue queuetopic, TopicExchange topicExchange) {
        return BindingBuilder.bind(queuetopic).to(topicExchange).with("jd_goods.#");
    }
}
