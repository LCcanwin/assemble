package com.jijian.goodstype.mapper;

import com.jijian.goodstype.POJO.goodsTypePOJO;
import com.jijian.goodstype.entity.goodsTypeEntity;

import java.util.List;

/**
 * Author: chenchuan
 * Date: 2019/12/19 13:43
 * Content:
 */
public interface goodsTypeMapper {
    /** 查询商品所有类别**/
    List<goodsTypePOJO> selectGoodsType();
    /** 添加店铺类别**/
    int insertShopType(goodsTypeEntity goodstypeEntity);
}
