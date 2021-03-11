package com.onway.poseidon.web.data;

import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author: fuheng
 * @date: 2021/3/5 11:44
 * @description:
 */
@Component
@Slf4j
@RabbitListener(queues = "jd_goods_topic_queue")
public class TopicReceiver {

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    @RabbitHandler
    public void process(String msg) throws IOException {
        log.info("消费消息：" + msg);
    }
}