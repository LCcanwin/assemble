package com.jijian.assemble.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;


@Data
@ApiModel("商品信息")
public class GoodsDTO implements Serializable {

    @ApiModelProperty("商品id")
    private Integer id;
    @ApiModelProperty("商品名称")
    private String name;
    @ApiModelProperty("商品图片")
    private String img;
    @ApiModelProperty("商品价格")
    private double price;
    @ApiModelProperty("商品类型")
    private int type;
    @ApiModelProperty("折后价")
    private double discount;
    @ApiModelProperty("商家id")
    private int businesId;
    @ApiModelProperty("商品库存")
    private int goodsNumber;
}
