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
@Table(name = "tbl_style")
public class Style extends BaseEntity {
    @Column(name = "name",type = MySqlTypeConstant.VARCHAR,length = 64)
    private String name;
}
