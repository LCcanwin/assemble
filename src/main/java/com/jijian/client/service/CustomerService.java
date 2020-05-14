package com.jijian.client.service;

import com.jijian.assemble.dto.GoodsDTO;
import com.jijian.client.Dto.CustomerDTO;
import com.jijian.client.entity.CustomerEntity;

public interface CustomerService {
    Integer addCustomer(CustomerEntity customerEntity);

    CustomerDTO loginByPassword(String phone,String password);

    Integer updatePhone(String id,String phone);
    Integer update(CustomerEntity customerEntity);

    CustomerDTO getByPhone(String phone);
    CustomerDTO get(String id);
}
