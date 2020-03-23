package com.jijian.assemble.mapper;


import com.jijian.assemble.entity.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Mapper
public interface GoodsMapper {
    Integer addGoods(Goods goods);
    Integer update(Goods goods);
    Integer delete(String id);
    //商品上架下架
    Integer upGoods(@Param("id") String id, @Param("upFlag")String upFlag);
    List<Goods> findList(Goods goods);
    //获取商家自己的商品
    List<Goods> findByBusiness(String businessId);
    List<Goods> findAllList();
    Goods getById(String id);
}
