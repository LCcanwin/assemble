package com.jijian.client.service;

import com.jijian.client.Dto.AddressDTO;
import com.jijian.client.Dto.OrderDTO;
import com.jijian.client.Dto.Province;
import com.jijian.client.Dto.RegionDTO;
import com.jijian.client.entity.Address;
import com.jijian.client.entity.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderService {
    List<OrderDTO> findOrderByCustomer(String customerId);
    Integer add(Order order);
    Integer update(Order order);
    OrderDTO get(String id);

    void addPink(Order order);
    void joinPink(Order order);

    Integer pay(String id);
    //发货
    Integer shipments(String id);
    //收获
    Integer reap(String id);
    //评价
    Integer evaluate(String id,String evaluate);

}
