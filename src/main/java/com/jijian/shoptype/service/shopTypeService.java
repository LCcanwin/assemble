package com.jijian.shoptype.service;

import com.jijian.shoptype.POJO.shoptypePOJO;
import com.jijian.shoptype.entity.AreaEntity;
import com.jijian.shoptype.entity.shoptypeEntity;

import java.util.List;

/**
 * Author: chenchuan
 * Date: 2019/12/19 14:33
 * Content:
 */
public interface shopTypeService {
    /** 查询店铺所有类别**/
    List<shoptypePOJO> searchShopType();


    List<AreaEntity> getAreaList();
}
