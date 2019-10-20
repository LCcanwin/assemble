package com.jijian.assemble.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import com.jijian.assemble.base.BaseEntity;
import lombok.Data;

/**
 * @Description todo
 * @Author luochao
 * @Date 2019/10/14 21:03
 */
@Data
@Table(name = "business_info")
public class Business extends BaseEntity {
    @Column(name = "number",type = MySqlTypeConstant.VARCHAR,length = 64)
    private String number;

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

    @Column(name = "real_name",type = MySqlTypeConstant.VARCHAR,length = 64)
    private String realName;

}
