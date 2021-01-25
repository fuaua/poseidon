package com.onway.poseidon.web.dto.request.user;

import com.onway.poseidon.web.dto.request.base.BaseRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: fuheng
 * @date: 2021/1/25 14:26
 * @description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserAddRequest extends BaseRequest {

    private String loginName;

    private String userName;

    private String userPass;
}
