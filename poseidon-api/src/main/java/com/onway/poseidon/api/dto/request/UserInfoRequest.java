package com.onway.poseidon.api.dto.request;

import lombok.*;

/**
 * @author: fuheng
 * @date: 2018-10-24 22:54
 * @desc: 功能描述
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
public class UserInfoRequest extends BaseApiRequest {

    private String method;

}
