package com.jijian.goodstype.service.impl;

import com.jijian.goodstype.POJO.goodsTypePOJO;
import com.jijian.goodstype.entity.goodsTypeEntity;
import com.jijian.goodstype.mapper.goodsTypeMapper;
import com.jijian.goodstype.service.goodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: chenchuan
 * Date: 2019/12/19 14:08
 * Content:
 */
@Service
public class goosTypeServiceImpl implements goodsTypeService {
    @Autowired private goodsTypeMapper goodstype;
    @Override
    public List<goodsTypePOJO> searchGoodsType() {
        return goodstype.selectGoodsType();
    }
}
