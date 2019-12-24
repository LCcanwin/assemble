package com.jijian.shoptype.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import com.jijian.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * Author: chenchuan
 * Date: 2019/12/18 14:40
 * Content:店铺类型
 */
@Getter
@Setter
@Table(name = "tbl_shop_type")
public class shoptypeEntity extends BaseEntity {
    /**
     * 类型名称
     * **/
    @Column(name = "shop_type_name",type = MySqlTypeConstant.VARCHAR,length = 64)
    private String shopTypeName;
    /**
     * 店铺类型编号
     * **/
    @Column(name = "shop_type_number",type = MySqlTypeConstant.VARCHAR,length = 64)
    private String shopTypeNumber;
}
