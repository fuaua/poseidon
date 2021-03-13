package com.onway.poseidon.web.data;

import com.onway.poseidon.service.utils.ElasticSearchService;
import lombok.extern.slf4j.Slf4j;
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
    private ElasticSearchService elasticSearchService;

    /**
     * 索引名
     */
    private static final String JD_INDEX_NAME = "jddata";

    /**
     * 分片数
     */
    private static final Integer JD_SHARD_NUM = 5;

    /**
     * 副本数
     */
    private static final Integer JD_REPLICAS_NUM = 1;

    @RabbitHandler
    public void process(String msg) throws IOException {
        log.info("消费消息：" + msg);
        boolean indexExist = elasticSearchService.indexExist(JD_INDEX_NAME);
        //如果索引不存在
        if (!indexExist) {
            elasticSearchService.createIndex(JD_INDEX_NAME, JD_SHARD_NUM, JD_REPLICAS_NUM);
        }
        boolean addRs = elasticSearchService.addDocuemnt(JD_INDEX_NAME, msg);
        if (!addRs) {
            log.info("插入es失败:{}", msg);
        }
    }
}