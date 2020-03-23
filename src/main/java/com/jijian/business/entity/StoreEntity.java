package com.jijian.business.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import com.jijian.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * 店铺实体
 */
@Getter
@Setter
@Table(name = "tbl_store")
public class StoreEntity  extends BaseEntity {
    /**
     * 店铺名称
     */
    @Column(name = "name",type = MySqlTypeConstant.INT,length = 64)
    private String name;

    /**
     * 营业执照
     */
    @Column(name = "img",type = MySqlTypeConstant.VARCHAR,length = 64)
    private String img;

}
