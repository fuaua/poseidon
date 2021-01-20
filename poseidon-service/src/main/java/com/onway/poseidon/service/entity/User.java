package com.onway.poseidon.service.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author: fuheng
 * @date: 2020-12-24 22:50
 * @desc: 功能描述
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("s_user")
public class User {

    private Long id;
    private String username;
    private String loginname;
    private String userpass;
    private Integer state;
    private Date createTime;

}
