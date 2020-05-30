package com.jijian.client.Dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("风格信息")
public class StyleDto  {

    @ApiModelProperty("风格id")
    private String id;
    @ApiModelProperty("风格id")
    private String name;
}
