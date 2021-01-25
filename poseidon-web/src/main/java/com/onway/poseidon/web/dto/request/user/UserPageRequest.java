package com.onway.poseidon.web.dto.request.user;

import com.onway.poseidon.common.base.request.BasePageRequest;
import com.onway.poseidon.common.base.request.BaseRequest;
import lombok.Data;

import java.util.Date;

/**
 * @author: fuheng
 * @date: 2021/1/21 10:50
 * @description:
 */
@Data
public class UserPageRequest extends BaseRequest {

    /**
     * 分页属性
     */
    private BasePageRequest pageRequest;

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
