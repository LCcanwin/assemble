package com.jijian.client.entity;


import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import com.jijian.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "tbl_version")
public class Version extends BaseEntity {
    @Column(name = "number",type = MySqlTypeConstant.INT,length = 64)
    private Integer number;
    @Column(name = "name",type = MySqlTypeConstant.VARCHAR,length = 64)
    private String name;
    @Column(name = "message",type = MySqlTypeConstant.VARCHAR,length = 64)
    private String message;
    @Column(name = "url",type = MySqlTypeConstant.VARCHAR,length = 64)
    private String url;
    @Column(name = "flag",type = MySqlTypeConstant.VARCHAR,length = 64)
    private String flag;

}
