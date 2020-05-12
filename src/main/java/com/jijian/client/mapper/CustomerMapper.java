package com.jijian.client.mapper;

import com.jijian.client.entity.CustomerEntity;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CustomerMapper {
   Integer addCustomer(CustomerEntity customerEntity);

   Integer updatePhone(@Param("id") String id, @Param("phone")String phone);
}
