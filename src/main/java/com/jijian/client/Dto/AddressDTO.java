package com.jijian.client.Dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


@Data
@ApiModel("收货地址信息")
public class AddressDTO implements Serializable {


    @ApiModelProperty("id")
    private String id;
    @ApiModelProperty("收货人姓名")
    private String name;
    @ApiModelProperty("收货人地址")
    private String address;
    @ApiModelProperty("收货人联系方式")
    private String phone;
    @ApiModelProperty("是否默认收获地址 0-是 1-否")
    private String flag;
    @ApiModelProperty("用户id")
    private String customerId;
    @ApiModelProperty("省")
    private RegionDTO province;
    @ApiModelProperty("市")
    private RegionDTO city;
    @ApiModelProperty("区")
    private RegionDTO town;







}
