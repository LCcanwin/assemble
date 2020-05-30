package com.jijian.client.entity;


import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import com.jijian.base.BaseEntity;
import io.swagger.models.auth.In;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Table(name = "tbl_address")
public class Address extends BaseEntity {
    @Column(name = "name",type = MySqlTypeConstant.VARCHAR,length = 64)
    private String name;
    @Column(name = "address",type = MySqlTypeConstant.VARCHAR,length = 64)
    private String address;
    @Column(name = "phone",type = MySqlTypeConstant.VARCHAR,length = 64)
    private String phone;
    @Column(name = "customer_id",type = MySqlTypeConstant.INT,length = 64)
    private Integer customerId;
    @Column(name = "flag",type = MySqlTypeConstant.VARCHAR,length = 64)
    private String flag;

    @Column(name = "province_id",type = MySqlTypeConstant.VARCHAR,length = 64)
    private String provinceId;
    @Column(name = "city_id",type = MySqlTypeConstant.VARCHAR,length = 64)
    private String cityId;
    @Column(name = "town_id",type = MySqlTypeConstant.VARCHAR,length = 64)
    private String townId;

//    private

}
