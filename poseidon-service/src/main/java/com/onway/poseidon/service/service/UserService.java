package com.onway.poseidon.service.service;

import com.onway.poseidon.service.entity.User;
import com.onway.poseidon.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: fuheng
 * @date: 2018-10-19 23:16
 * @desc: 功能描述
 */
@Service
public class UserService {


    @Autowired
    private UserMapper userMapper;

    public User selectById(Long id) {
        return userMapper.selectById(id);
    }

}
