package com.onway.poseidon.common.base.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: fuheng
 * @date: 2021/1/21 10:51
 * @description:
 */
@Data
public class BasePageRequest extends BaseRequest implements Serializable {

    /**
     * 每页数据条数
     */
    private Integer pageSize = 10;

    /**
     * 当前第几页
     */
    private Integer pageNum = 1;

}
