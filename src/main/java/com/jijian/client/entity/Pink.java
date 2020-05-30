package com.jijian.client.entity;


import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import com.jijian.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 拼单表
 */
@Getter
@Setter
@Table(name = "tbl_pink")
public class Pink extends BaseEntity {
    //拼单号
    @Column(name = "pink_num",type = MySqlTypeConstant.VARCHAR,length = 64)
    private String pinkNum;

    //团长id
    @Column(name = "head_id",type = MySqlTypeConstant.INT,length = 64)
    private Integer headId;
    //团长订单id
    @Column(name = "head_order_id",type = MySqlTypeConstant.INT,length = 64)
    private Integer headOrderId;
    //参团id
    @Column(name = "join_id",type = MySqlTypeConstant.INT,length = 64)
    private Integer joinId;
    //参团订单id
    @Column(name = "join_order_id",type = MySqlTypeConstant.INT,length = 64)
    private Integer joinOrderId;
    //拼单商品id
    @Column(name = "goods_id",type = MySqlTypeConstant.VARCHAR,length = 64)
    private String goodsId;
    //开始时间
    @Column(name = "start_time",type = MySqlTypeConstant.DATETIME,length = 64)
    private Date startTime;
    //结束时间
    @Column(name = "end_time",type = MySqlTypeConstant.DATETIME,length = 64)
    private Date endTime;
    /** 状态1进行中2已完成3未完成 */
    @Column(name = "status",type = MySqlTypeConstant.INT,length = 64)
    private Integer status;






}
