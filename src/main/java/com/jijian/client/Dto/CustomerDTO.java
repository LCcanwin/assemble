package com.jijian.client.Dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


@Data
@ApiModel("用户信息")
public class CustomerDTO implements Serializable {


    @ApiModelProperty("用户id")
    private String id;
    @ApiModelProperty("姓名")
    private String name;
    @ApiModelProperty("密码")
    private String password;
    @ApiModelProperty("昵称")
    private String nickName;
    @ApiModelProperty("头像")
    private String img;
    @ApiModelProperty("电话")
    private String phone;
    @ApiModelProperty("生日")
    private Date birthday;
    @ApiModelProperty("关注数")
    private Integer focusNum;
    @ApiModelProperty("粉丝数")
    private Integer fansNum;
    @ApiModelProperty("红包卷数")
    private Integer redNum;
    @ApiModelProperty("角色")
    private String role;





}
