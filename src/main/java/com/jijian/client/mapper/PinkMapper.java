package com.jijian.client.mapper;


import com.jijian.client.Dto.OrderDTO;
import com.jijian.client.Dto.PinkDTO;
import com.jijian.client.entity.Order;
import com.jijian.client.entity.Pink;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface PinkMapper {

   List<PinkDTO> findPinkByCustomer(String customerId);
   Integer add(Pink pink);
   PinkDTO get(String id);
   PinkDTO getByPinkNum(String pinkNum);
   List<PinkDTO> findPinkByGoodsId(String goodsId);
   Integer update(Pink pink);

}
