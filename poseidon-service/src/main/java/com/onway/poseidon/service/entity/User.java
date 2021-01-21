package com.onway.poseidon.service.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
public class User extends BaseLongEntity {

    private String userName;
    private String loginName;
    private String userPass;
    private Integer state;
    private Date createTime;

}
