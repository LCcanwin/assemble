package com.jijian.client.entity;


import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import com.jijian.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Table(name = "tbl_type")
public class Type extends BaseEntity {
    @Column(name = "name",type = MySqlTypeConstant.VARCHAR,length = 64)
    private String name;
    @Column(name = "parent_id",type = MySqlTypeConstant.VARCHAR,length = 64)
    private String parentId;
    @Column(name = "style_flag",type = MySqlTypeConstant.VARCHAR,length = 1)
    private String styleFlag;
    private List<Type>  subTypeList;
    private List<Style> styleList;
}
