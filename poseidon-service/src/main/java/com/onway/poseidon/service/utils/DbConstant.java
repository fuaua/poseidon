package com.onway.poseidon.service.utils;

import com.baomidou.mybatisplus.core.toolkit.StringPool;

import java.io.Serializable;

/**
 * @author: fuheng
 * @date: 2021/1/25 19:13
 * @description: 数据库相关字段名
 */
public interface DbConstant extends StringPool,Serializable {

    /**
     * 主键set方法名
     */
    String INVOKE_SET_ID = "setId";

}
