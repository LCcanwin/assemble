package com.jijian.client.Dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;


@Data
@ApiModel("市信息")
public class City implements Serializable {

    @ApiModelProperty("id")
    private String id;
    @ApiModelProperty("地区名称")
    private String name;
    @ApiModelProperty("父ID")
    private String pid;
    @ApiModelProperty("区域等级 1 省/直辖市  2 市 3 区县")
    private String level;
    @ApiModelProperty("区县")
    private List<RegionDTO> towns;









}
