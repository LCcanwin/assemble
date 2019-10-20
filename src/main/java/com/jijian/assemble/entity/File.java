package com.jijian.assemble.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import com.jijian.assemble.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class File extends BaseEntity {
    /**
     * 原文件名
     * **/
    @Column(name = "file_name",type = MySqlTypeConstant.VARCHAR,length = 64)
    private String    fileName;
    /**
     * 新文件名
     * **/
    @Column(name = "file_new_name",type = MySqlTypeConstant.VARCHAR,length = 64)
    private String   fileNewName;
    /**
     * 商家id
     * **/
    @Column(name = "b_id",type = MySqlTypeConstant.VARCHAR,length = 64)
    private String   bId;
    /**
     * 用户id
     * **/
    @Column(name = "u_id",type = MySqlTypeConstant.VARCHAR,length = 64)
    private String   uId;

}
