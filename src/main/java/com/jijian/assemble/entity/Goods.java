package com.jijian.assemble.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import com.jijian.base.BaseEntity;
import lombok.Data;

/**
 * @Description todo
 * @Author luochao
 * @Date 2019/10/14 21:09
 */
@Data
@Table(name = "goods")
public class Goods extends BaseEntity {
    @Column(name = "name",type = MySqlTypeConstant.VARCHAR,length = 64)
    private String name;

    @Column(name = "img",type = MySqlTypeConstant.VARCHAR,length = 64)
    private String img;

    @Column(name = "price",type = MySqlTypeConstant.DECIMAL,length = 64)
    private double price;

    @Column(name = "type",type = MySqlTypeConstant.INT,length = 64)
    private int type;

    @Column(name = "discount",type = MySqlTypeConstant.DOUBLE,length = 64)
    private double discount;

    @Column(name = "busines_id",type = MySqlTypeConstant.INT,length = 11)
    private int businesId;

    @Column(name = "goods_number",type = MySqlTypeConstant.INT,length = 11)
    private int goodsNumber;
}
