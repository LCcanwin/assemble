package com.jijian.shoptype.service.impl;

import com.jijian.shoptype.POJO.shoptypePOJO;
import com.jijian.shoptype.entity.AreaEntity;
import com.jijian.shoptype.entity.shoptypeEntity;
import com.jijian.shoptype.mapper.shopTypeMapper;
import com.jijian.shoptype.service.shopTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: chenchuan
 * Date: 2019/12/19 14:34
 * Content:
 */
@Service
public class shopTypeServiceImpl implements shopTypeService {
    @Autowired private shopTypeMapper shoptypeMapper;

    @Override
    public List<shoptypePOJO> searchShopType() {
        return shoptypeMapper.selectShopType();
    }

    @Override
    public List<AreaEntity> getAreaList() {
        return shoptypeMapper.getAreaList();
    }
}
