package com.jijian.assemble.service.impl;

import com.jijian.assemble.entity.Goods;
import com.jijian.assemble.mapper.GoodsMapper;
import com.jijian.assemble.mapper.UserMapper;
import com.jijian.assemble.service.GoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {


    @Resource
    private GoodsMapper goodsMapper;

    @Override
    public Integer addGoods(Goods goods) {

        return goodsMapper.addGoods(goods);
    }

    @Override
    public Integer update(Goods goods) {
        return goodsMapper.update(goods);
    }

    @Override
    public Integer delete(String id) {
        return goodsMapper.delete(id);
    }

    @Override
    public List<Goods> findList(Goods goods) {
        return goodsMapper.findList(goods);
    }

    @Override
    public List<Goods> findAllList() {
        return goodsMapper.findAllList();
    }

    @Override
    public Goods getById(String id) {
        return goodsMapper.getById(id);
    }

    @Override
    public List<Goods> findByBusiness(String businessId) {
        return goodsMapper.findByBusiness(businessId);
    }
}
