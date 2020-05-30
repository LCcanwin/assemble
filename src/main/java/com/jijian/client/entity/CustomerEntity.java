package com.jijian.client.entity;


import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import com.jijian.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Table(name = "tbl_customer")
public class CustomerEntity  extends BaseEntity {
    @Column(name = "name",type = MySqlTypeConstant.VARCHAR,length = 64)
    private String name;
    @Column(name = "password",type = MySqlTypeConstant.VARCHAR,length = 64)
    private String password;
    @Column(name = "nick_name",type = MySqlTypeConstant.VARCHAR,length = 64)
    private String nickName;
    @Column(name = "img",type = MySqlTypeConstant.VARCHAR,length = 64)
    private String img;
    @Column(name = "phone",type = MySqlTypeConstant.VARCHAR,length = 64)
    private String phone;
    @Column(name = "birthday",type = MySqlTypeConstant.DATE,length = 64)
    private Date birthday;
    @Column(name = "focus_num",type = MySqlTypeConstant.INT,length = 64)
    private Integer focusNum;
    @Column(name = "fans_num",type = MySqlTypeConstant.INT,length = 64)
    private Integer fansNum;
    @Column(name = "red_num",type = MySqlTypeConstant.INT,length = 64)
    private Integer redNum;
    @Column(name = "role",type = MySqlTypeConstant.VARCHAR,length = 64)
    private String role;
    @Column(name = "password_flag",type = MySqlTypeConstant.VARCHAR,length = 64)
    private String passwordFlag;


    private List<Address> addressList;
}
