package com.onway.poseidon.service.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * @author: fuheng
 * @date: 2021/1/21 20:37
 * @description:
 */
@Data
public class BaseLongEntity implements Serializable {

    @TableId(type = IdType.INPUT)
    private Long id;
}
