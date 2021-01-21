package com.onway.poseidon.web.dto.request;

import com.onway.poseidon.web.dto.request.base.BasePageRequest;
import lombok.Data;

import java.util.Date;

/**
 * @author: fuheng
 * @date: 2021/1/21 10:50
 * @description:
 */
@Data
public class UserListRequest extends BasePageRequest {

    /**
     * 用户名
     */
    private String username;

    /**
     * 状态
     */
    private Integer state;

    /**
     * 创建时间
     */
    private Date date;

}
