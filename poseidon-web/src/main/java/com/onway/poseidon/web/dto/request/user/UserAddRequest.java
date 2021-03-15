package com.onway.poseidon.web.dto.request.user;

import com.onway.poseidon.common.base.request.BaseRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * @author: fuheng
 * @date: 2021/1/25 14:26
 * @description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "新增用户入参")
public class UserAddRequest extends BaseRequest {

    /**
     * 登录名
     */
    @NotBlank(message = "登录名不能为空")
    @Size(min = 3, max = 20, message = "登录名须在3-20位")
    @ApiModelProperty(value = "登录名", required = true)
    private String loginName;

    /**
     * 用户名
     */
    @NotBlank(message = "用户名不能为空")
    @Size(min = 3, max = 20, message = "用户名须在3-20位")
    @ApiModelProperty(value = "用户名", required = true)
    private String userName;

    /**
     * 用户密码
     */
    @NotBlank(message = "密码不能为空")
    @Size(min = 3, max = 20, message = "密码须在3-20位")
    @ApiModelProperty(value = "密码", required = true)
    private String userPass;
}
