package com.jijian.client.service;

import com.jijian.client.entity.CustomerEntity;

public interface CustomerService {
    Integer addCustomer(CustomerEntity customerEntity);

    Integer updatePhone(String id,String phone);
}
