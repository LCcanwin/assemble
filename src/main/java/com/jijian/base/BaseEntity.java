package com.jijian.base;


import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.command.BaseModel;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;
@Setter
@Getter
public class BaseEntity extends BaseModel implements Serializable {

    @Id
    @Column(name = "id", type = MySqlTypeConstant.INT, isKey = true, length = 64)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected String id;

    /**
     * 创建时间
     */
    @Column(name = "create_date", type = MySqlTypeConstant.DATETIME, isNull = false)
    protected Date createDate;

    /**
     * 更新时间
     */
    @Column(name = "update_date", type = MySqlTypeConstant.DATETIME, isNull = false)
    protected Date updateDate;

    /**
     * 创建人
     */
    @Column(name = "create_user", type = MySqlTypeConstant.VARCHAR, isNull = false)
    protected String createUser;

    /**
     * 修改人
     */
    @Column(name = "update_user", type = MySqlTypeConstant.VARCHAR, isNull = false)
    protected String updateUser;

    /**
     * 是否被删除 0-正常 1-已删除
     */
    @Column(name = "deleted", type = MySqlTypeConstant.INT, isNull = false, length = 1)
    protected Boolean deleted;
}
