package com.jijian.assemble.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description 商家登陆注册后的信息
 * @Author luochao
 * @Date 2019/10/20 15:58
 */
@Data
@ApiModel("商家登陆注册后的信息")
public class UserInfoDTO implements Serializable {

    @ApiModelProperty("商家id")
    private Integer userId;

    @ApiModelProperty("商家姓名")
    private String userName;

    @ApiModelProperty("商家账号")
    private String userNumber;

    @ApiModelProperty("商家生成的token")
    private String token;


}
