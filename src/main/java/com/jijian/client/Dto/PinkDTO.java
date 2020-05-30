package com.jijian.client.Dto;


import com.jijian.assemble.dto.GoodsDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


@Data
@ApiModel("拼单信息")
public class PinkDTO implements Serializable {


    @ApiModelProperty("id")
    private String id;
    @ApiModelProperty("拼单号")
    private String pinkNum;
    @ApiModelProperty("团长")
    private CustomerDTO head;
    @ApiModelProperty("团长订单")
    private OrderDTO headOrder;
    @ApiModelProperty("参团")
    private CustomerDTO join;
    @ApiModelProperty("参团订单")
    private OrderDTO joinOrder;
    @ApiModelProperty("拼单商品")
    private GoodsDTO goods;
    @ApiModelProperty("开始时间")
    private Date startTime;
    @ApiModelProperty("结束时间")
    private Date endTime;
    @ApiModelProperty("状态1进行中2已完成3未完成")
    private Integer status;

    private Integer headId;
    private Integer headOrderId;
    private Integer joinId;
    private Integer joinOrderId;
    private String goodsId;







}
