package com.onway.poseidon.service.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author: fuheng
 * @date: 2021/3/15 10:50
 * @description: poseidon自定义分业务类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PoPage<T> implements Serializable {

    /**
     * 当前页
     */
    private Long pageNum;

    /**
     * 单页大小
     */
    private Long pageSize;

    /**
     * 总页数
     */
    private Long pageCount;

    /**
     * 数据
     */
    private List<T> list;


}
