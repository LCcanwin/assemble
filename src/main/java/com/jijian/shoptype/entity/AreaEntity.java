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
@Table(name = "comm_area")
public class AreaEntity extends BaseEntity {
    /**
     * 区域代码
     * **/
    @Column(name = "code",type = MySqlTypeConstant.VARCHAR,length = 64)
    private String code;
    /**
     * 区域名称
     * **/
    @Column(name = "name",type = MySqlTypeConstant.VARCHAR,length = 64)
    private String name;

    /**
     * 上级区域代码
     */
    @Column(name = "parent_code",type = MySqlTypeConstant.VARCHAR,length = 64)
    private String parentCode;
}
