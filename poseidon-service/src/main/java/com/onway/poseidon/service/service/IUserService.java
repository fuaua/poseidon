package com.onway.poseidon.service.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.onway.poseidon.common.base.request.BasePageRequest;
import com.onway.poseidon.service.entity.User;
import com.onway.poseidon.service.utils.PoPage;

/**
 * @author: fuheng
 * @date: 2021/1/21 14:12
 * @description:
 */
public interface IUserService {

    /**
     * 用户列表分页查询
     * @param basePageRequest
     * @param queryWrapper
     * @return
     */
    PoPage<User> userPageList(BasePageRequest basePageRequest, QueryWrapper<User> queryWrapper);


}
