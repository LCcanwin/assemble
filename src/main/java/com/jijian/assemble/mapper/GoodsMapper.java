package com.jijian.assemble.mapper;


import com.jijian.assemble.entity.Goods;
import org.apache.ibatis.annotations.Mapper;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Mapper
public interface GoodsMapper {
    Integer addGoods(Goods goods);
    Integer update(Goods goods);
    Integer delete(String id);
    List<Goods> findList(Goods goods);
    //获取商家自己的商品
    List<Goods> findByBusiness(String businessId);
    List<Goods> findAllList();
    Goods getById(String id);
}
