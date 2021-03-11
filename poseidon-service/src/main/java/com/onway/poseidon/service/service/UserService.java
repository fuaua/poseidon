package com.onway.poseidon.service.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.onway.poseidon.service.entity.BaseLongEntity;
import com.onway.poseidon.service.entity.User;
import com.onway.poseidon.service.mapper.UserMapper;
import com.onway.poseidon.service.service.base.BaseService;
import com.onway.poseidon.service.utils.ElasticSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

/**
 * @author: fuheng
 * @date: 2020-12-24 22:50
 * @desc: 用户service
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserService extends BaseService<User, UserMapper> implements IUserService {

    @Autowired
    private ElasticSearchService elasticSearchService;

    public void delete(String indexName, int shardNum, int replicasNum) throws IOException {
        elasticSearchService.createIndex(indexName, shardNum, replicasNum);
    }


}
