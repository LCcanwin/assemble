package com.jijian.client.service;

import com.jijian.client.Dto.OrderDTO;
import com.jijian.client.Dto.PinkDTO;
import com.jijian.client.entity.Order;
import com.jijian.client.entity.Pink;

import java.util.List;

public interface PinkService {
    List<PinkDTO> findPinkByCustomer(String customerId);
    Integer add(Pink pink);
    PinkDTO get(String id);
    List<PinkDTO> findPinkByGoodsId(String goodsId);


}
