package com.jijian.client.Dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;


@Data
@ApiModel("版本信息")
public class VersionDTO implements Serializable {
    @ApiModelProperty("id")
    private String id;
    @ApiModelProperty("版本号")
    private Integer number;
    @ApiModelProperty("版本名称")
    private String name;
    @ApiModelProperty("版本信息")
    private String message;
    @ApiModelProperty("该版本安装包下载链接")
    private String url;
    @ApiModelProperty("是否强制更新 0-是 1-否")
    private String flag;







}
