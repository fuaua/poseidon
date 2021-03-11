package com.onway.poseidon.service.utils;

import com.onway.poseidon.common.exception.BusinessException;
import org.elasticsearch.client.IndicesClient;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.common.settings.Settings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author: fuheng
 * @date: 2021/3/10 18:08
 * @description: es操作服务类
 */
@Component
public class ElasticSearchService {

    /**
     * 分片数量参数
     */
    private static final String NUMBER_OF_SHARDS = "index.number_of_shards";

    /**
     * 备份分片数量
     */
    private static final String NUMBER_OF_REPLICAS = "index.number_of_replicas";

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    /**
     * 创建索引
     * @param indexName 索引名称
     * @param shardNum 分片数
     * @param replicasNum 备份数
     * @return 是否创建成功
     * @throws IOException
     */
    public void createIndex(String indexName, int shardNum, int replicasNum) throws IOException {
        //使用client获取操作索引的对象
        IndicesClient indicesClient = restHighLevelClient.indices();
        //具体操作，获取返回值
        CreateIndexRequest createRequest = new CreateIndexRequest(indexName).settings(Settings.builder()
                .put(NUMBER_OF_SHARDS, shardNum)
                .put(NUMBER_OF_REPLICAS, replicasNum)
                .build());
        CreateIndexResponse response = indicesClient.create(createRequest, RequestOptions.DEFAULT);
        if (!response.isAcknowledged()) {
            throw new BusinessException("创建es索引异常");
        }
    }


}
