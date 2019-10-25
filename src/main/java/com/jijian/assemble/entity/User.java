package com.jijian.assemble.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;

import com.jijian.base.BaseEntity;
import lombok.Data;


@Data
@Table(name = "user_info")
public class User extends BaseEntity {

    @Column(name = "user_name",type = MySqlTypeConstant.VARCHAR,length = 64)
    private String userName;
    @Column(name = "user_number",type = MySqlTypeConstant.VARCHAR,length = 64)
    private String userNumber;
    @Column(name = "pass_word",type = MySqlTypeConstant.VARCHAR,length = 64)
    private String passWord;
    @Column(name = "tell_phone",type = MySqlTypeConstant.VARCHAR,length = 64)
    private String tellPhone;
    @Column(name = "user_img",type = MySqlTypeConstant.VARCHAR,length = 64)
    private String userImg;
    @Column(name = "sex",type = MySqlTypeConstant.INT,length = 1)
    private int sex;

}
