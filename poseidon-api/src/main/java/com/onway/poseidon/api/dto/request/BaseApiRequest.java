package com.onway.poseidon.api.dto.request;

import lombok.*;

/**
 * @author: fuheng
 * @date: 2018-10-24 22:54
 * @desc: 功能描述
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseApiRequest {

    private String username;
    private String userpass;

}
