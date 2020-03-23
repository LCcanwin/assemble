package com.jijian.back.entity;


import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import com.jijian.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * 后台登录用户
 */
@Getter
@Setter
@Table(name = "sys_user")
public class SysUser  extends BaseEntity {
    @Column(name = "name",type = MySqlTypeConstant.VARCHAR,length = 64)
    private String name;
    @Column(name = "password",type = MySqlTypeConstant.VARCHAR,length = 64)
    private String password;

}
