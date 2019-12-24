package com.jijian.goodstype.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import com.jijian.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * Author: chenchuan
 * Date: 2019/12/19 13:40
 * Content: 商品类别
 */
@Getter
@Setter
@Table(name = "tbl_goods_type")
public class goodsTypeEntity  extends BaseEntity {
    /**
     * 商品类型名称
     * **/
    @Column(name = "goods_type_name",type = MySqlTypeConstant.VARCHAR,length = 64)
    private String goodsTypeName;
    /**
     * 商品类型编号
     * **/
    @Column(name = "goods_type_number",type = MySqlTypeConstant.VARCHAR,length = 64)
    private String goodsTypeNumber;
}
