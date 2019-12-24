package com.jijian.business.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import com.jijian.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * Author: chenchuan
 * Date: 2019/12/19 16:02
 * Content:
 */
@Getter
@Setter
@Table(name = "tbl_business")
public class businessEntity extends BaseEntity {
    @Column(name = "number",type = MySqlTypeConstant.VARCHAR,length = 64)
    private String number;
    /**
     * 商家名称
     * **/
    @Column(name = "name",type = MySqlTypeConstant.VARCHAR,length = 64)
    private String name;

    @Column(name = "password",type = MySqlTypeConstant.VARCHAR,length = 64)
    private String password;

    @Column(name = "img",type = MySqlTypeConstant.VARCHAR,length = 64)
    private String img;

    @Column(name = "sex",type = MySqlTypeConstant.INT,length = 64)
    private int sex;

    @Column(name = "status",type = MySqlTypeConstant.INT,length = 64)
    private int status;

    @Column(name = "card",type = MySqlTypeConstant.VARCHAR,length = 64)
    private String card;

    @Column(name = "license",type = MySqlTypeConstant.VARCHAR,length = 64)
    private String license;
    /**
     * 商家真实姓名
     * **/
    @Column(name = "real_name",type = MySqlTypeConstant.VARCHAR,length = 64)
    private String realName;

    /***
     * 商家类型id
     */
    @Column(name = "shop_type_id",type = MySqlTypeConstant.INT,length = 64)
    private Integer shopTypeId;
    /***
     * 商品类型id
     */
    @Column(name = "goods_type_id",type = MySqlTypeConstant.INT,length = 64)
    private Integer goodsTypeId;

    /**
     * 认证的备注
     * **/
    @Column(name = "remark",type = MySqlTypeConstant.VARCHAR,length = 255)
    private String remark;
}
