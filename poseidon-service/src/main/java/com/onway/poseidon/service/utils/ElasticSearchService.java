package com.onway.poseidon.service.utils;

import com.alibaba.fastjson.JSON;
import com.onway.poseidon.common.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.IndicesClient;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @author: fuheng
 * @date: 2021/3/10 18:08
 * @description: es操作服务类
 */
@Component
@Slf4j
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
     * 判断索引是否存在
     * @param indexName 索引名
     * @return
     */
    public boolean indexExist(String indexName) throws IOException {
        boolean exist = false;
        GetIndexRequest getIndexRequest = new GetIndexRequest(indexName);
        exist = restHighLevelClient.indices().exists(getIndexRequest, RequestOptions.DEFAULT);
        return exist;
    }

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

    /**
     * 新增文档
     * @param indexName 索引名
     * @param jsonData 文档数据
     * @return
     * @throws IOException
     */
    public boolean addDocuemnt(String indexName, String jsonData) throws IOException {
        IndexRequest indexRequest = new IndexRequest(indexName);
        indexRequest.source(jsonData, XContentType.JSON);
        IndexResponse indexResp = restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
        return Objects.equals(indexResp.status(), RestStatus.CREATED);
    }

    /**
     * 判断某id的文档是否存在
     * @param indexName
     * @param id
     */
    public boolean docExistOfId(String indexName, String id) throws IOException {
        GetRequest getRequest = new GetRequest(indexName, id);
        return restHighLevelClient.exists(getRequest, RequestOptions.DEFAULT);
    }

    /**
     * 根据id查询文档
     * @param indexName
     * @param id
     * @return
     * @throws IOException
     */
    public GetResponse getDocById(String indexName, String id) throws IOException {
        GetRequest getRequest = new GetRequest(indexName, id);
        return restHighLevelClient.get(getRequest, RequestOptions.DEFAULT);
    }

    /**
     * 更新某条文档
     * @param indexName 索引名
     * @param docId docId
     * @param jsonDoc
     * @return
     * @throws IOException
     */
    public boolean updateDoc(String indexName, String docId, String jsonDoc) throws IOException {
        UpdateRequest request = new UpdateRequest(indexName, docId);
        request.doc(jsonDoc);
        UpdateResponse updateResp = restHighLevelClient.update(request, RequestOptions.DEFAULT);
        return Objects.equals(updateResp.status(), RestStatus.OK);
    }

    /**
     * 搜索
     * @param indexName 索引名
     * @param map 参数map
     * @param from 分页起始index
     * @param size 每页大小
     * @throws IOException
     */
    public String search(String indexName, Map<String, Object> map, Integer from, Integer size) throws IOException {
        SearchRequest searchRequest = new SearchRequest(indexName);
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        map.forEach((k, v) -> sourceBuilder.query(QueryBuilders.termQuery(k, v)));
        sourceBuilder.from(from);
        sourceBuilder.size(size);
        sourceBuilder.timeout(new TimeValue(10, TimeUnit.SECONDS));
        searchRequest.source(sourceBuilder);
        SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        return JSON.toJSONString(searchResponse);
    }

}
