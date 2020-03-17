package com.jijian.assemble.service;

import com.jijian.assemble.entity.Goods;

import java.util.List;


public interface GoodsService {
    Integer addGoods(Goods goods);
    Integer update(Goods goods);
    Integer delete(String id);
    List<Goods> findList(Goods goods);
    List<Goods> findAllList();
    Goods getById(String id);
    List<Goods> findByBusiness(String businessId);
}
