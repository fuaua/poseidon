package com.onway.poseidon.web.dto.request.user;

import com.onway.poseidon.common.base.request.BaseRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author: fuheng
 * @date: 2021/3/11 11:49
 * @description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "删除用户入参")
public class UserDelRequest extends BaseRequest {

    @NotBlank(message = "删除id不能为空")
    @ApiModelProperty(value = "删除主键", required = true)
    private String id;

}
