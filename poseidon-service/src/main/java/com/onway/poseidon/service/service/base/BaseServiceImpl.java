package com.onway.poseidon.service.service.base;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @author: fuheng
 * @date: 2021/1/21 16:44
 * @description:
 */
public class BaseServiceImpl<ID, M extends BaseMapper<T>, T> extends ServiceImpl<M, T> {

}
