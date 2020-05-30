package com.jijian.client.Dto;


import com.jijian.assemble.dto.GoodsDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


@Data
@ApiModel("订单信息")
public class OrderDTO implements Serializable {
    @ApiModelProperty("id")
    private String id;
    @ApiModelProperty("订单号")
    private String orderNumber;
    @ApiModelProperty("用户")
    private CustomerDTO customer;
    @ApiModelProperty("商品")
    private GoodsDTO goods;
    @ApiModelProperty("订单商品总数")
    private Integer totalNum;
    @ApiModelProperty("订单总价")
    private BigDecimal totalPrice;
    @ApiModelProperty("实际支付金额")
    private BigDecimal payPrice;
    @ApiModelProperty("支付状态")
    private Integer paid;
    @ApiModelProperty("支付时间")
    private Date payTime;
    @ApiModelProperty("支付方式")
    private String payType;
    @ApiModelProperty("订单状态（0：待发货；1：待收货；2：已收货；3：待评价；4：完成）")
    private Integer status;
    @ApiModelProperty("用户评价")
    private String evaluate;
    @ApiModelProperty("备注")
    private String mark;
    @ApiModelProperty("拼团信息")
    private PinkDTO pink;
    @ApiModelProperty("是否拼团 0是 1否")
    private String pinkFlag;



    private Integer uid;
    private String goodsId;
    private String pinkId;


}
