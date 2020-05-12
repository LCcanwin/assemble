package com.jijian.client.service.impl;

import com.jijian.client.entity.CustomerEntity;
import com.jijian.client.mapper.CustomerMapper;
import com.jijian.client.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;
    @Override
    public Integer addCustomer(CustomerEntity customerEntity) {
        return customerMapper.addCustomer(customerEntity);
    }

    @Override
    public Integer updatePhone(String id, String phone) {
        return customerMapper.updatePhone(id,phone);
    }
}
