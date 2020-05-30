package com.jijian.client.entity;


import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import com.jijian.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@Table(name = "tbl_order")
public class Order extends BaseEntity {

    /** 订单号 */
    @Column(name = "order_number",type = MySqlTypeConstant.VARCHAR,length = 64)
    private String orderNumber;

    /** 用户id */
    @Column(name = "uid",type = MySqlTypeConstant.INT,length = 64)
    private Integer uid;
    /** 商品id */
    @Column(name = "goods_id",type = MySqlTypeConstant.VARCHAR,length = 64)
    private String goodsId;

    /** 店铺id */
    @Column(name = "store_id",type = MySqlTypeConstant.VARCHAR,length = 64)
    private Integer storeId;

    /** 订单商品总数 */
    @Column(name = "totalNum",type = MySqlTypeConstant.INT,length = 64)
    private Integer totalNum;

    /** 订单总价 */
    @Column(name = "total_price",type = MySqlTypeConstant.DECIMAL,length = 64)
    private BigDecimal totalPrice;

    /** 实际支付金额 */
    @Column(name = "pay_price",type = MySqlTypeConstant.DECIMAL,length = 64)
    private BigDecimal payPrice;

    /** 支付状态 */
    @Column(name = "paid",type = MySqlTypeConstant.INT,length = 64)
    private Integer paid;

    /** 支付时间 */
    @Column(name = "pay_time",type = MySqlTypeConstant.DATE,length = 64)
    private Date payTime;

    /** 支付方式 */
    @Column(name = "pay_type",type = MySqlTypeConstant.INT,length = 64)
    private String payType;

    /** 订单状态（0：待付款；1：待发货；2：待收货；3：待评价；4;已完成） */
    @Column(name = "status",type = MySqlTypeConstant.INT,length = 64)
    private Integer status;

    /** 用户评价 */
    @Column(name = "evaluate",type = MySqlTypeConstant.VARCHAR,length = 255)
    private String evaluate;
    /** 备注 */
    @Column(name = "mark",type = MySqlTypeConstant.VARCHAR,length = 255)
    private String mark;

    /** 是否拼团订单 0是 1否*/
    @Column(name = "pink_flag",type = MySqlTypeConstant.VARCHAR,length = 64)
    private String pinkFlag;

    /** 拼团id 0没有拼团 */
    @Column(name = "pink_id",type = MySqlTypeConstant.INT,length = 64)
    private Integer pinkId;




}
