package com.onway.poseidon.service.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.onway.poseidon.common.base.request.BasePageRequest;
import com.onway.poseidon.service.entity.User;
import com.onway.poseidon.service.mapper.UserMapper;
import com.onway.poseidon.service.service.base.BaseService;
import com.onway.poseidon.service.utils.PoPage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: fuheng
 * @date: 2020-12-24 22:50
 * @desc: 用户service
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserService extends BaseService<User, UserMapper> implements IUserService {

    public PoPage<User> userPageList(BasePageRequest basePageRequest, QueryWrapper<User> queryWrapper) {
        return this.pageList(basePageRequest, queryWrapper);
    }

}
