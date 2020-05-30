package com.jijian.client.Dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;


@Data
@ApiModel("收货地址信息")
public class RegionDTO implements Serializable {


    @ApiModelProperty("id")
    private String id;
    @ApiModelProperty("地区名称")
    private String name;
    @ApiModelProperty("父ID")
    private String pid;
    @ApiModelProperty("区域等级 1 省/直辖市  2 市 3 区县")
    private String level;







}
