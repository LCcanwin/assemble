package com.jijian.client.Dto;


import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import com.jijian.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@ApiModel("分类信息")
public class TypeDto  {
    @ApiModelProperty("分类id")
    private String id;
    @ApiModelProperty("名称")
    private String name;
    @ApiModelProperty("上级id")
    private String parentId;
    @ApiModelProperty("是否拥有风格 0是 1否")
    private String styleFlag;
    @ApiModelProperty("子分类")
    private List<TypeDto> subTypeList;
    @ApiModelProperty("风格")
    private List<StyleDto> styleList;
}
