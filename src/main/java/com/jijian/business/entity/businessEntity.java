package com.jijian.business.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import com.jijian.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Author: chenchuan
 * Date: 2019/12/19 16:02
 * Content:
 */
@Getter
@Setter
@Table(name = "tbl_business")
public class businessEntity extends BaseEntity {
    /**
     * 商家名称
     * **/
    @Column(name = "name",type = MySqlTypeConstant.VARCHAR,length = 64)
    private String name;
    /**
     * 商家电话
     */
    @Column(name = "number",type = MySqlTypeConstant.VARCHAR,length = 64)
    private String number;

    /**
     * 登录密码
     */
    @Column(name = "password",type = MySqlTypeConstant.VARCHAR,length = 64)
    private String password;

    /**
     * 商家身份证照片 正面
     */
    @Column(name = "img",type = MySqlTypeConstant.VARCHAR,length = 64)
    private String img;

    /**
     * 商家身份证照片 背面
     */
    @Column(name = "img1",type = MySqlTypeConstant.VARCHAR,length = 64)
    private String img1;

    /**
     * 行政区划
     */
    @Column(name = "area",type = MySqlTypeConstant.VARCHAR,length = 64)
    private String area;

    /**
     * 是否审核 0已审核 1未审核
     */
    @Column(name = "status",type = MySqlTypeConstant.INT,length = 1)
    private int status;
    /**
     * 商家是否认证 0已认证  1未认证
     */
    @Column(name = "attestation_flag",type = MySqlTypeConstant.INT,length = 1)
    private int attestationFlag;
    /**
     * 商家类型 0个人 1个体商家
     */
    @Column(name = "type",type = MySqlTypeConstant.INT,length = 1)
    private int type;

    @Column(name = "card",type = MySqlTypeConstant.VARCHAR,length = 64)
    private String card;

    @Column(name = "license",type = MySqlTypeConstant.VARCHAR,length = 64)
    private String license;
    /**
     * 商家真实姓名
     * **/
    @Column(name = "real_name",type = MySqlTypeConstant.VARCHAR,length = 64)
    private String realName;

    /**
     * 认证的备注
     * **/
    @Column(name = "remark",type = MySqlTypeConstant.VARCHAR,length = 255)
    private String remark;

    /**
     * 店铺信息
     */
    private List<StoreEntity> storeEntityList;
}
