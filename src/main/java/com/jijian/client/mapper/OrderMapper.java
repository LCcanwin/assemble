package com.jijian.client.mapper;


import com.jijian.client.Dto.AddressDTO;
import com.jijian.client.Dto.OrderDTO;
import com.jijian.client.Dto.Province;
import com.jijian.client.Dto.RegionDTO;
import com.jijian.client.entity.Address;
import com.jijian.client.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface OrderMapper {

   List<OrderDTO> findOrderByCustomer(String customerId);
   Integer add(Order order);
   Integer update(Order order);
   OrderDTO get(String id);
   OrderDTO getByOrderNumber(String orderNum);

}
