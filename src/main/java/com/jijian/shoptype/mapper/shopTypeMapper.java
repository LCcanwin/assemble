package com.jijian.shoptype.mapper;


import com.jijian.shoptype.POJO.shoptypePOJO;
import com.jijian.shoptype.entity.shoptypeEntity;

import java.util.List;

/**
 * Author: chenchuan
 * Date: 2019/12/19 13:44
 * Content:
 */
public interface shopTypeMapper {
    /** 查询店铺所有类别**/
    List<shoptypePOJO> selectShopType();

    /** 添加店铺类别**/
    int insertGoodsType(shoptypeEntity shoptypeEntity);
}
