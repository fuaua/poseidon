package com.onway.poseidon.web.dto.request.user;

import com.onway.poseidon.common.base.request.BasePageRequest;
import lombok.Data;

import java.io.Serializable;

/**
 * @author: fuheng
 * @date: 2021/1/21 10:50
 * @description:
 */
@Data
public class UserPageRequest implements Serializable {

    /**
     * 分页属性
     */
    private BasePageRequest basePageRequest = new BasePageRequest();

    /**
     * 用户名
     */
    private String userName;

    /**
     * 状态
     */
    private Integer state;

}
