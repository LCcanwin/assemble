package com.jijian.file.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.command.BaseModel;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import com.jijian.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * Author: chenchuan
 * Date: 2019/10/25 11:04
 * Content: 文件公共上传类
 */
@Getter
@Setter
@Table(name = "tbl_file")
public class FileEntity extends BaseEntity {

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
    /***
     * 文件类型 1.身份证正面  2.份证反面 ， 3. 营业执照  4.商品图片
     * */
    @Column(name = "file_type", type = MySqlTypeConstant.VARCHAR)
    private String fileType;
    /**
     * 文件路径
     */
    @Column(name = "file_url", type = MySqlTypeConstant.VARCHAR)
    private String fileUrl;
}
