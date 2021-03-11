package com.onway.poseidon.service.service;

import java.io.IOException;

/**
 * @author: fuheng
 * @date: 2021/1/21 14:12
 * @description:
 */
public interface IUserService {

    void delete(String indexName, int shardNum, int replicasNum) throws IOException;

}
