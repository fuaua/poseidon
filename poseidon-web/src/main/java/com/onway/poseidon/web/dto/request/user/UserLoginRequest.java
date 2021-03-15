package com.onway.poseidon.web.dto.request.user;


import com.onway.poseidon.common.base.request.BaseRequest;
import lombok.Data;

/**
 * @author: fuheng
 * @date: 2021/1/25 15:40
 * @description:
 */
@Data
public class UserLoginRequest extends BaseRequest {

    private String userName;

    private String passWord;

    private String checkCode;
}
