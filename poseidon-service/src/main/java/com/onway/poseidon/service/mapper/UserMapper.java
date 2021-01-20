package com.onway.poseidon.service.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.onway.poseidon.service.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author: fuheng
 * @date: 2020-12-24 22:50
 * @desc: 功能描述
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
