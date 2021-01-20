package com.onway.poseidon.service.service;

import com.onway.poseidon.service.entity.User;
import com.onway.poseidon.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author: fuheng
 * @date: 2020-12-24 22:50
 * @desc: 功能描述
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User selectById(Long id) {
        return userMapper.selectById(id);
    }

    public void addUser() {
        User user = User.builder()
                .id(1L)
                .loginname("lisi")
                .username("里斯")
                .userpass("23432")
                .state(1)
                .createTime(new Date())
                .build();
        userMapper.insert(user);
        User user2 = User.builder()
                .id(2L)
                .loginname("wangwu")
                .username("王五")
                .userpass("123456")
                .state(1)
                .createTime(new Date())
                .build();
        userMapper.insert(user2);
    }

}
