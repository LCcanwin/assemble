package com.jijian.assemble.dto;


import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import com.jijian.client.Dto.StyleDto;
import com.jijian.client.Dto.TypeDto;
import com.jijian.client.entity.Style;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;


@Data
@ApiModel("商品信息")
public class GoodsDTO implements Serializable {

    @ApiModelProperty("商品id")
    private String id;
    @ApiModelProperty("商品名称")
    private String name;
    @ApiModelProperty("商品图片")
    private String img;
    @ApiModelProperty("单买价")
    private double price;
    @ApiModelProperty("商品类型")
    private int type;
    @ApiModelProperty("会员价")
    private double discount;
    @ApiModelProperty("拼单价")
    private double unitPrice;
    @ApiModelProperty("商家id")
    private int businesId;
    @ApiModelProperty("商品库存")
    private int goodsNumber;
    //商品规格
    @ApiModelProperty("商品规格")
    private String specification;
    //是否预售
    @ApiModelProperty("是否预售")
    private String readyFlag;
    //承诺发货时间
    @ApiModelProperty("承诺发货时间")
    private String deliveryDate;
    //7天无理由退换
    @ApiModelProperty("7天无理由退换")
    private String returnsFlag;
    //假一罚十
    @ApiModelProperty("假一罚十")
    private String flag;
    @ApiModelProperty("是否上架")
    private String upFlag;
    @ApiModelProperty("出售状态 0正常 1限时促销  2发现好物 3今日推荐")
    private String salesFlag;
    @ApiModelProperty("分类")
    private TypeDto typeDto;
    @ApiModelProperty("子分类")
    private TypeDto subTypeDto;
    @ApiModelProperty("风格")
    private StyleDto styleDto;



}
